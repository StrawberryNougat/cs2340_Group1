package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class GameTwoController implements Initializable {
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameTwoSprite;

    @FXML
    int numLives;

    @FXML
    Label numLivesText;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    ArrayList<Button> buttons;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8,
                button9));
    }

    public void showButtonSymbol(ActionEvent e) {
        for (int i = 0; i < buttons.size(); i++) {
            if (e.getSource() == buttons.get(i)) {
                if (/*player one turns*/) {
                    Image xSymbol = new Image("src/main/resources/x.png");
                    ImageView view = new ImageView(xSymbol);
                    (buttons.get(i)).setGraphic(view);
                    //check if player one has won or tie
                    //change turn to another player
                } else { //means it's player two's turn
                    Image oSymbol = new Image("src/main/resources/o.png");
                    ImageView view = new ImageView(oSymbol);
                    (buttons.get(i)).setGraphic(view);
                    //check if player two has won or tie
                    //change turn to another player
                }
            }
        }
    }
}
