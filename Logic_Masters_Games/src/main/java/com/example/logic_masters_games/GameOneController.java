package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class GameOneController {
    @FXML
    Label usernameDisplay;

    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }
}
