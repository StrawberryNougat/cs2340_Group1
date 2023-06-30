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
import java.util.*;


public class GameTwoController implements Initializable {
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameTwoSprite;

    private Stage stage;
    private Scene scene;
    private Parent root;


    int numLives;

    int score = 5;

    @FXML
    Label numLivesText;

    @FXML
    Label gameTwoLoseText;

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
        buttons = new ArrayList<>(
                Arrays.asList(null, button1, button2, button3, button4, button5,
                        button6, button7, button8, button9));
        changeNumLivesText(numLives);
    }
    public void processMoves(ActionEvent e) throws IOException{
        // -------------------- PLAYER'S TURN: --------------------
        // Step 1: Get Player input through her button press.
        Button currButton = (Button) e.getSource();
        // Step 2: Find which button it was among button1 ~ button9.
        int integerForButton = 0;
        for (int i = 0; i < buttons.size(); i++) {
            if (currButton.equals(buttons.get(i))) {
                // When found, mark it with "x" and disable that button.
                integerForButton = i;
                buttons.get(i).setText("x");
                buttons.get(i).setDisable(true);
                break;
            }
        }
        // Step 3: Store Player's input to a list.
        ticTacToeReferee.playerPositions.add(integerForButton);
        // Step 4: Check whether this move has caused her to win or tie the game.
        String check = ticTacToeReferee.checkWinner();
        if (check.equals("You won!")) {
            // Transition to Win screen if Player wins.
            goToWinScreen(e);
            return;
        }
        if (check.equals("Tie!")) {
            // Clear the board and play again if it's a tie.
            clearBoard();
        }
        // -------------------- OPPONENT'S TURN: --------------------
        // Step 1: Get Opponent input randomly (an int from 1 to 9).
        int integerForOpponent = rand.nextInt(9) + 1;
        // Step 2: If spots are already taken, try again.
        while ((ticTacToeReferee.playerPositions.contains(integerForOpponent) ||
                ticTacToeReferee.opponentPositions.contains(integerForOpponent))) {
            integerForOpponent = ticTacToePlayer.markBoard(rand.nextInt(9) + 1);
        }
        // Step 3: Mark Opponent's input spot with "o" and disable that button.
        buttons.get(integerForOpponent).setText("o");
        buttons.get(integerForOpponent).setDisable(true);
        // Step 4: Store Opponent's input to a list.
        ticTacToeReferee.opponentPositions.add(integerForOpponent);
        // Step 5: Check whether this move has caused her to win or tie the game.
        check = ticTacToeReferee.checkWinner();
        if (check.equals("Opponent won!")) {
            // When Opponent wins, decrement Player's numLives and score.
            numLives--;
            score--;
            changeNumLivesText(numLives);
            // Transition to Lose screen if Player runs out of life.
            if (numLives <= 0) {
                goToLoseScreen(e);
            }
            // Clear the board and play again if Player still has some lives.
            clearBoard();
        }
        if (check.equals("Tie!")) {
            // Clear the board and play again if it's a tie.
            clearBoard();
        }
    }

    public static void goToWinScreen(ActionEvent event) throws IOException {
        WinScreenController winScreen = new WinScreenController();
        winScreen.switchToWinScreen(event);
    }

    public void goToLoseScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_two_lose_screen.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GameTwoLoseController gameTwoLoseController = loader.getController();
        gameTwoLoseController.setGameTwoLoseText(score);
        scene = new Scene(root);
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

    public ArrayList<Button> getButtons() {
        return this.buttons;
    }
}
