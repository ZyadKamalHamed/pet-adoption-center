package controller;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Animals.*;
import model.Application.*;
import java.io.IOException;
import javafx.collections.transformation.FilteredList;

public class ManagerDashboardController extends Controller<AdoptionCentre>{

    @FXML private Button removeBtn;
    @FXML private Button addBtn;
    @FXML private Button userListBtn;
    @FXML private Button closeBtn;


    @FXML private Button filterAllBtn;
    @FXML private Button filterCatBtn;
    @FXML private Button filterDogBtn;
    @FXML private Button filterRabbitBtn;

    @FXML private TableView<Animal> animalsTable;
    @FXML private TableColumn<Animal, String> nameCol;
    @FXML private TableColumn<Animal, String> typeCol;
    @FXML private TableColumn<Animal, Number> ageCol;
    @FXML private TableColumn<Animal, String> statusCol;

    @FXML
    private void initialize() {
        closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        statusCol.setCellValueFactory(cellData -> cellData.getValue().isAdoptedProperty());
        animalsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        animalsTable.setItems(model.getAnimals().getAnimals());

        FilteredList<Animal> filteredAnimals = new FilteredList<>(animalsTable.getItems(), p -> true);
        animalsTable.setItems(filteredAnimals);
        filterAllBtn.setOnAction(e -> filteredAnimals.setPredicate(animal -> true));
        filterCatBtn.setOnAction(e -> filteredAnimals.setPredicate(animal -> animal.getClass().getSimpleName().equals("Cat")));
        filterDogBtn.setOnAction(e -> filteredAnimals.setPredicate(animal -> animal.getClass().getSimpleName().equals("Dog")));
        filterRabbitBtn.setOnAction(e -> filteredAnimals.setPredicate(animal -> animal.getClass().getSimpleName().equals("Rabbit")));

        removeBtn.disableProperty().bind(animalsTable.getSelectionModel().selectedItemProperty().isNull());
        removeBtn.setOnAction(e-> removeAnimal());
        addBtn.setOnAction(e -> loadAddAnimal());
        userListBtn.setOnAction(e -> loadUserList());


    }


    private void loadAddAnimal() {
        try {
            ViewLoader.showStage(model, "/view/AddAnimalView.fxml", "Add Animal", new Stage());
        } catch (IOException e) {
            System.err.println("error loading add animal");
        }

    }
    private void removeAnimal() {
       Animal selected = animalsTable.getSelectionModel().getSelectedItem();
       if (selected != null){
           if (selected.isAdopted()){
               showErrorWindow("InvalidOperationException", selected.getName() + " is already adopted");
           }else {
               model.getAnimals().remove(selected);
           }
       }
    }
    private void loadUserList() {
        try {
            ViewLoader.showStage(model, "/view/UserListView.fxml", "User List", new Stage());
        } catch (IOException e) {
            System.err.println("error loading user list");
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


