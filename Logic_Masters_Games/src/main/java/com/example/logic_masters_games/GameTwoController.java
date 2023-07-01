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
    private TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
    private HumanPlayer player = new HumanPlayer();
    private ComputerPlayer opponent = new ComputerPlayer();
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
        // Step 2: Call playItsMove() of the "player" object.
        player.playItsMove(buttons, currButton, ticTacToeReferee);
        // Step 3: Check whether this move has caused her to win or tie the game.
        String check = ticTacToeReferee.checkWinner();
        if (check.equals("You won!")) {
            // Transition to Win screen if Player wins.
            goToWinScreen(e);
            return;
        }
        if (check.equals("Tie!")) {
            // Clear the board and play again if it's a tie.
            ticTacToeReferee.clearBoard(buttons);
        }
        // -------------------- OPPONENT'S TURN: --------------------
        // Step 1: Call playItsMove() of the "opponent" object.
        opponent.playItsMove(buttons, currButton, ticTacToeReferee);
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
            ticTacToeReferee.clearBoard(buttons);
        }
        if (check.equals("Tie!")) {
            // Clear the board and play again if it's a tie.
            ticTacToeReferee.clearBoard(buttons);
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

    public ArrayList<Button> getButtons() {
        return this.buttons;
    }

}
