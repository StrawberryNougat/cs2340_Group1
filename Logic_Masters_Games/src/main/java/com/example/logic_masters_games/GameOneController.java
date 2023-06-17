package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;


public class GameOneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameOneSprite;

    @FXML
    Label question_text;

    @FXML
    Button choice_one;

    @FXML
    Button choice_two;

    @FXML
    Button choice_three;

    @FXML
    Label game_one_score;

    boolean choice_one_correct;
    boolean choice_two_correct;
    boolean choice_three_correct;
    
    int score_to_win;

    int currentScore;


    Riddle a = new Riddle(
            "David’s parents have three sons: Snap, Crackle, and what’s the name of the third son?",
            "Easy",
            "David",
            "Snap",
            "Crackle");
    Riddle b = new Riddle(
            "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
            "Easy",
            "Your shadow",
            "Your face",
            "Your legs");
    Riddle c = new Riddle(
            "What has many keys but can’t open a single lock?",
            "Easy",
            "Piano",
            "Guitar",
            "Violin");
    Riddle d = new Riddle(
            "I shave every day, but my beard stays the same. What am I?",
            "Med",
            "A Barber",
            "A Magician",
            "A Carpenter");
    Riddle e = new Riddle(
            "What gets wet while drying?",
            "Med",
            "A Towel",
            "A Toothbrush",
            "A Shoe");
    Riddle f = new Riddle(
            "The more of this there is, the less you see. What is it?",
            "Med",
            "Darkness",
            "Space",
            "Sadness");
    Riddle g = new Riddle(
            "What can fill a room but takes up no space?",
            "Hard",
            "Light",
            "Dust",
            "Energy");
    Riddle h = new Riddle(
            "What is 3/7 chicken, 2/3 cat and 2/4 goat?",
            "Hard",
            "Chicago",
            "Detroit",
            "Atlanta");
    Riddle i = new Riddle(
            "If two’s company, and three’s a crowd, what are four and five?",
            "Hard",
            "Nine",
            "Seven",
            "Three"
    );

    Riddle[] easies = {a, b, c};
    Riddle[] mediums = {d, e, f};
    Riddle[] hards = {g, h, i};
    private RiddleLibrary riddleLib = new RiddleLibrary(score_to_win/4, score_to_win, easies, mediums, hards);

    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }

    public void changeScore(int score) {
        game_one_score.setText(" " + score);
    }

    public void showSprite(Image gameSprite) {
        gameOneSprite.setImage(gameSprite);

    }
    public void changeWinningScore(int score_to_win) {
        this.score_to_win = score_to_win;
    }
    public void changeQuestion(Riddle riddle) {
        question_text.setText("Question: " + riddle.content);
        changeButtons(riddle);
    }
    public void changeButtons(Riddle riddle) {
        Random rand = new Random();
//        int upperbound = 3;
        int found = rand.nextInt(4) + 1; //1 to 3
        if (found == 1) {
            choice_one.setText(riddle.right_answer);
            choice_two.setText(riddle.wrong_answer1);
            choice_three.setText(riddle.wrong_answer2);
            choice_one_correct = true;
            choice_two_correct = false;
            choice_three_correct = false;
        }
        if (found == 2) {
            choice_one.setText(riddle.wrong_answer1);
            choice_two.setText(riddle.wrong_answer2);
            choice_three.setText(riddle.right_answer);
            choice_one_correct = false;
            choice_two_correct = false;
            choice_three_correct = true;
        }
        if (found == 3) {
            choice_one.setText(riddle.wrong_answer1);
            choice_two.setText(riddle.right_answer);
            choice_three.setText(riddle.wrong_answer2);
            choice_one_correct = false;
            choice_two_correct = true;
            choice_three_correct = false;
        }
    }

    public void answerChoiceOne(ActionEvent event) throws IOException {
        if (choice_one_correct) {
            currentScore++;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null && currentScore < score_to_win) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(a);
            //call changequestion method with new riddle based on current score

        } else {
            currentScore--;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null && currentScore < score_to_win) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(b);
            //call changequestion method with new riddle based on current score
        }
    }
    public void answerChoiceTwo(ActionEvent event) throws IOException {
        if (choice_two_correct) {
            currentScore++;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(c);
            //call changequestion method with new riddle based on current score

        } else {
            currentScore--;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            changeQuestion(riddleLib.select(currentScore));
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
            //call changequestion method with new riddle based on current score
        }
    }
    public void answerChoiceThree(ActionEvent event) throws IOException {
        if (choice_three_correct) {
            currentScore++;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(b);
            //call changequestion method with new riddle based on current score

        } else {
            currentScore--;
            changeScore(currentScore);
            if (riddleLib.select(currentScore) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_one_lose.fxml"));
                stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            changeQuestion(riddleLib.select(currentScore));
            //call changequestion method with new riddle based on current score
        }
    }

    public static void goToWinScreen() {
//        if (currentScore >= score_to_win) {
//            WinScreenController winScreen = new WinScreenController();
//            winScreen.switchToWinScreen();
//        }
    }

    public int getCurrentScore() {
        return this.currentScore;
    }

    public void setCurrentScore(int x) {
        this.currentScore = x;
    }
}
