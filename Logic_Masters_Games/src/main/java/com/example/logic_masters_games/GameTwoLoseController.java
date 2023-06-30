package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GameTwoLoseController implements Initializable {
    @FXML
    Label gameTwoLoseText;
    public void setGameTwoLoseText(int score) {
        this.gameTwoLoseText.setText("You lost all your lives - but you final score is... " + score);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGameTwoLoseText(0);


    }
}
