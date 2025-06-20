package controller;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Users.*;
import model.Application.*;

public class UserListController extends Controller<AdoptionCentre>{
    @FXML private ListView<User> userLv;
    @FXML private Button closeBtn;

    @FXML
    private void initialize(){
        closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());
        userLv.setItems(model.getUsers().getUsers());
    }

}
