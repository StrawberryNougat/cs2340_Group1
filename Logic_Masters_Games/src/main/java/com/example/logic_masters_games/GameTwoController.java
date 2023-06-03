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

    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }

    public void showSprite(Image gameSprite) {
        gameTwoSprite.setImage(gameSprite);
    }
}
