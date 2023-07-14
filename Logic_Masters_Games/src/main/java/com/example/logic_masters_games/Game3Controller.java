package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class Game3Controller {
    private int numLives;
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameThreeSprite;

    @FXML
    Label gameThreeLivesDisplay;

    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }

    public void showSprite(Image gameSprite) {
        gameThreeSprite.setImage(gameSprite);
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
        gameThreeLivesDisplay.setText("Lives: " + numLives);
    }


}
