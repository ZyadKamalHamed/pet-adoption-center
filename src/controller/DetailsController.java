package controller;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Animals.*;
import model.Users.*;
import model.Application.*;

public class DetailsController extends Controller<AdoptionCentre>{
    @FXML private ListView<Animal> adoptedAnimalsLv;
    @FXML private Button closeBtn;
    @FXML private Label nameLbl;

    @FXML
    private void initialize(){
        closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());
        Customer customer = (Customer) AdoptionCentre.getLoggedInUser();
        nameLbl.setText(customer.getName());
        adoptedAnimalsLv.setItems(customer.adoptedAnimals().getAnimals());



    }

}
