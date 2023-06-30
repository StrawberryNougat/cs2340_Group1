package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;


public class GameTwoController implements Initializable {
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameTwoSprite;


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
    private Random rand = new Random();


    private boolean is_player_turn = true;

    private TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
    private TicTacToePlayer ticTacToePlayer = new TicTacToePlayer();

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
        buttons = new ArrayList<>(Arrays.asList(null, button1, button2, button3, button4, button5, button6, button7, button8,
                button9));
        changeNumLivesText(numLives);

    }

    public void showButtonSymbol(ActionEvent e) throws IOException{
        for (int i = 1; i < buttons.size(); i++) {
            if (e.getSource() == buttons.get(i)) {
                if (buttons.get(i).getText().isEmpty()) {
                    if ((buttons.get(i)).getGraphic() == null) {   // check if the grid is not filled yet
//                        ImageView view = new ImageView(xSymbol);
//                        (buttons.get(i)).setGraphic(view);
                        buttons.get(i).setText("x");
                        int integerForButton = i;
                        ticTacToeReferee.playerPositions.add(integerForButton);
                        String check = ticTacToeReferee.checkWinner();
                        if (check.equals("You won!")) {
                            goToWinScreen(e);
                        }
                        if (check.equals("Tie!")) {
                            clearBoard();
                        }
                        //check if player one has won or tie
                        //change turn to another player
                        buttons.get(i).setDisable(true);
                        is_player_turn = false;
                    }
                    //means it's player two's turn
//                    ImageView view = new ImageView(oSymbol);
//                    (buttons.get(i)).setGraphic(view);
                }
//                while (!is_player_turn) {
                    int pos = i;
                    while (pos != 0 && (ticTacToeReferee.playerPositions.contains(pos) || ticTacToeReferee.opponentPositions.contains(pos))) {
                        pos = ticTacToePlayer.markBoard(rand.nextInt(9) + 1);
                    }
                    buttons.get(pos).setText("o");
                    buttons.get(pos).setDisable(true);
                    int integerForButton = pos;
                    ticTacToeReferee.opponentPositions.add(integerForButton);
                    //check if player two has won or tie
                    //change turn to another player
                    String check = ticTacToeReferee.checkWinner();
                    if (check.equals("Opponent won!")) {
                        numLives--;
                        changeNumLivesText(numLives);
                        if (numLives <= 0) {
                            goToLoseScreen(e);
                        }
                        clearBoard();
                    }
                    if (check.equals("Tie!")) {
                        clearBoard();
                    }
//                    is_player_turn = true;
//                }
            }
        }
    }

    public static void goToWinScreen(ActionEvent event) throws IOException {
        WinScreenController winScreen = new WinScreenController();
        winScreen.switchToWinScreen(event);
    }

    public void goToLoseScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game_one_lose.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void clearBoard() {
        for (int i = 1; i < buttons.size(); i++) {
            buttons.get(i).setText("");
            buttons.get(i).setDisable(false);
        }
        ticTacToeReferee.playerPositions.clear();
        ticTacToeReferee.opponentPositions.clear();
    }
}
