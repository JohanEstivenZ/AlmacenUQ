package Controlador;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controlador {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}