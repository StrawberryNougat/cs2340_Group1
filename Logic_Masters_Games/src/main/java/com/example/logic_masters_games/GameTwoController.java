package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GameTwoController {
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameTwoSprite;

    @FXML
    int numLives;

    @FXML
    Label numLivesText;

    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }

    public void showSprite(Image gameSprite) {
        gameTwoSprite.setImage(gameSprite);
    }

    public void changeNumLives(int number) {
        this.numLives = number;
    }

    public void changeNumLivesText(int numLives) {
        numLivesText.setText("Number of lives: " + numLives);
    }
}
