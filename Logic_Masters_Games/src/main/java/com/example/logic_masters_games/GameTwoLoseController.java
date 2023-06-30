package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameTwoLoseController {
    @FXML
    Label gameTwoLoseText = new Label("test label");
    public void setGameTwoLoseText(String text) {
        gameTwoLoseText.setText(text);
    }
}
