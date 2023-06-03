package com.example.sprint1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Game3Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}