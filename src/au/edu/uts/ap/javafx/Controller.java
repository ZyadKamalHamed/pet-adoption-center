package au.edu.uts.ap.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.*;


public abstract class Controller<M> {
    protected M model;
    protected Stage stage;
    @FXML private Button closeBtn;

}