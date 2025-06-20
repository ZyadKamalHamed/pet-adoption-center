package controller;
import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Animals.Animal;
import model.Animals.Cat;
import model.Animals.Dog;
import model.Animals.Rabbit;
import model.Application.AdoptionCentre;

import java.io.IOException;

public class AddAnimalController extends Controller<AdoptionCentre>{
    @FXML private Button addBtn;
    @FXML private Button closeBtn;
    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<String> typeComboBox;

    @FXML
    private void initialize() {
        closeBtn.setOnAction(e -> ((Stage) closeBtn.getScene().getWindow()).close());
        typeComboBox.getItems().addAll("Cat", "Dog", "Rabbit");
        typeComboBox.setValue("Cat");
        addBtn.setDisable(true);

        nameField.textProperty().addListener((obs, oldText, newText) -> validateInput());
        ageField.textProperty().addListener((obs, oldText, newText) -> validateInput());
        typeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> validateInput());

        validateInput();

    }

    private void validateInput() {
        boolean bothEmpty = nameField.getText().isEmpty() && ageField.getText().isEmpty();
        addBtn.setDisable(bothEmpty);
    }
    @FXML
    private void handleAdd() {
        String type = typeComboBox.getValue();
        String name = nameField.getText();
        String ageStr = ageField.getText();
        int age;
        try {age = Integer.parseInt(ageStr);}
        catch (NumberFormatException e) {showErrorWindow("InvalidOperationException", "Age must be an integer"); return;}

        for (Animal existing : model.getAnimals().getAnimals()) {
            if (existing.getName().equalsIgnoreCase(name)){
                showErrorWindow("InvalidOperationException", name + " already exists in the adoption centre");
                return;
            }
        }
        Animal animal = null;
        switch (type) {
            case "Cat":
                animal = new Cat(name, age);
                break;
            case "Dog":
                animal = new Dog(name, age);
                break;
            case "Rabbit":
                animal = new Rabbit(name, age);
                break;
            default:
                break;
        }
        if (animal != null) {
            try {
                model.getAnimals().add(animal);
            } catch (Exception e) {
                showErrorWindow(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        nameField.clear();
        ageField.clear();
        typeComboBox.setValue("Cat");
        stage.close();

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
