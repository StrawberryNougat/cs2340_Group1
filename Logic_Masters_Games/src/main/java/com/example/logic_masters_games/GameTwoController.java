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

    Image xSymbol = new Image("x.png");
    Image oSymbol = new Image("o.png");



    private boolean is_player_turn = true;

    private TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();

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
                if (is_player_turn) {
                    if ((buttons.get(i)).getGraphic() == null) {   // check if the grid is not filled yet
                        ImageView view = new ImageView(xSymbol);
//                        (buttons.get(i)).setGraphic(view);
                        buttons.get(i).setText("x");
                        int integerForButton = i;
                        ticTacToeReferee.playerPositions.add(integerForButton);
                        String check = ticTacToeReferee.checkWinner();
                        //check if player one has won or tie
                        //change turn to another player
                        is_player_turn = false;
                    }
                } else { //means it's player two's turn
                    ImageView view = new ImageView(oSymbol);
//                    (buttons.get(i)).setGraphic(view);
                    buttons.get(i).setText("o");
                    int integerForButton = i;
                    ticTacToeReferee.opponentPositions.add(integerForButton);
                    //check if player two has won or tie
                    //change turn to another player
                    String check = ticTacToeReferee.checkWinner();
                    is_player_turn = true;
                }
            }
        }
    }
}
