package controller;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Animals.*;
import model.Users.*;
import model.Application.*;
import java.io.IOException;


public class CustomerDashboardController extends Controller<AdoptionCentre>{
    @FXML private Button myDetailsBtn;
    @FXML private Button closeBtn;
    @FXML private Button adoptBtn;
    @FXML private ListView<Animal> animalsLv;
    @FXML private Label welcomeLbl;

    @FXML
    private void initialize(){
       Customer customer = (Customer) AdoptionCentre.getLoggedInUser();
       welcomeLbl.setText("Welcome " + customer.getFirstName());
       myDetailsBtn.setOnAction(event -> loadMyDetails());
       FilteredList<Animal> availableAnimals = new FilteredList<>(model.getAnimals().getAnimals(), animal -> !animal.isAdopted());
       animalsLv.setItems(availableAnimals);

       adoptBtn.disableProperty().bind(animalsLv.getSelectionModel().selectedItemProperty().isNull());
       adoptBtn.setOnAction(event -> adoptAnimal());
       closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());

    }

    private void adoptAnimal() {
        Animal animal = animalsLv.getSelectionModel().getSelectedItem();
        if (animal == null) {return;}
        Customer customer = (Customer) AdoptionCentre.getLoggedInUser();

        if(animal.isAdopted()){
            String name = animal.getName();
            showErrorWindow("InvalidOperationException", name + " is already adopted");
            return;
        }
        if(!customer.canAdopt(animal)){
            String type = animal.getClass().getSimpleName();
            showErrorWindow("InvalidOperationException", "Cannot adopt " + animal.getName() + ", adoption limit for " + type + "s reached");
            return;
        }
        animal.adopt();
        customer.adoptedAnimals().add(animal);
        model.getAnimals().remove(animal);
    }

    private void loadMyDetails() {
        try {
            ViewLoader.showStage(model, "/view/DetailsView.fxml", "Details", new Stage());
        } catch (IOException e) {
            System.err.println("error loading my details");
        }
    }
    private void showErrorWindow(String errorType, String errorMessage) {
        try {
            ErrorController.setErrorDetails(errorType, errorMessage);
            ViewLoader.showStage(null, "/view/ErrorView.fxml", "Error", new Stage());
        } catch (IOException e) {
            System.err.println("Error loading error view.");
        }
    }
}
