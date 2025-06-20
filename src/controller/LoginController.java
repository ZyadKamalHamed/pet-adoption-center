package controller;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Exceptions.*;
import model.Users.*;
import model.Application.*;
import java.io.IOException;

public class LoginController extends Controller<AdoptionCentre>{

    @FXML private Button exitBtn;
    @FXML private Button loginBtn;
    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private TextField managerIDField;


    @FXML
    private void initialize(){
        exitBtn.setOnAction(e -> Platform.exit());
        loginBtn.setOnAction(e -> handleLogin());

        usernameField.textProperty().addListener((obs, oldVal, newVal) -> updateLoginButtonState());
        emailField.textProperty().addListener((obs, oldVal, newVal) -> updateLoginButtonState());
        managerIDField.textProperty().addListener((obs, oldVal, newVal) -> updateLoginButtonState());

        updateLoginButtonState();
    }

    private void updateLoginButtonState(){
        boolean managerNotEmpty = !managerIDField.getText().isEmpty();
        boolean customerNotEmpty = !emailField.getText().isEmpty() || !usernameField.getText().isEmpty();

        loginBtn.setDisable(!(managerNotEmpty || customerNotEmpty));

        if (managerNotEmpty){
            usernameField.setDisable(true);
            emailField.setDisable(true);
        }else{
            usernameField.setDisable(false);
            emailField.setDisable(false);
        }
        managerIDField.setDisable(customerNotEmpty);

        boolean isManagerValid = !managerIDField.getText().isEmpty();
        boolean isCustomerValid = !emailField.getText().isEmpty() && !usernameField.getText().isEmpty();
        loginBtn.setDisable(!(isManagerValid || isCustomerValid));
    }

    private void handleLogin(){
        String username = usernameField.getText();
        String email = emailField.getText();
        String managerID = managerIDField.getText();

        try {
            if (!managerID.isEmpty()) {
                try {
                    int managerIDNumber = Integer.parseInt(managerID);
                    Manager manager = model.getUsers().validateManager(String.valueOf(managerIDNumber));
                } catch (NumberFormatException e){
                    loadErrorWindow("InvalidOperationException", "ID must be an integer");
                    return;
                }
                loadManagerView();
            } else if (!email.isEmpty() && !username.isEmpty()) {
                Customer customer = model.getUsers().validateCustomer(username, email);
                loadCustomerView();
            }
        } catch (InvalidOperationException e) {
            loadErrorWindow("InvalidOperationException", "ID must be an integer");
        } catch (UnauthorizedAccessException e) {
            loadErrorWindow("UnauthorizedAccessException", e.getMessage());
        }
    }
        private void loadManagerView(){
           try {
               ViewLoader.showStage(model, "/view/ManagerDashboard.fxml", "Manager Dashboard", stage);
           } catch (IOException e){
               loadErrorWindow("UnauthorizedAccessException", "Invalid credentials.");
           }
        }
        private void loadCustomerView() {
            try {
                ViewLoader.showStage(model, "/view/CustomerDashboard.fxml", "Customer Dashboard", stage);
            } catch (IOException e) {
                loadErrorWindow("UnauthorizedAccessException", "Invalid credentials.");
            }
        }
    private void loadErrorWindow(String errorType, String errorMessage) {
        try {
            ErrorController.setErrorDetails(errorType, errorMessage);
            ViewLoader.showStage(null, "/view/ErrorView.fxml", "Error", new Stage());
        } catch (IOException e) {
            System.err.println("Error loading error view.");
        }
    }

}
