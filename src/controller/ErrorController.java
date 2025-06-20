package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Application.AdoptionCentre;

public class ErrorController extends Controller<AdoptionCentre> {
    @FXML private Label errorLbl;
    @FXML private Label errorMessageLbl;
    @FXML private Button closeBtn;

    private static String errorType;
    private static String errorMessage;

    public static void setErrorDetails(String type, String message){
        errorType = type;
        errorMessage = message;
    }

    @FXML
        private void initialize(){
        errorLbl.setText(errorType);
        errorMessageLbl.setText(errorMessage);
        closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());
    }
}
