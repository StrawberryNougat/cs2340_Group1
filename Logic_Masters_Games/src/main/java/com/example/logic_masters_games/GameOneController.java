package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;


public class GameOneController {
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
    Riddle[] easies = {a};
    Riddle[] normals = {b};

    Riddle[] hards = {c};





    private RiddleLibrary riddleLib = new RiddleLibrary(3, 7, easies, normals, hards);


    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
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
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(a);
            //call changequestion method with new riddle based on current score
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
        } else {
            currentScore--;
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(b);
            //call changequestion method with new riddle based on current score
        }
    }
    public void answerChoiceTwo(ActionEvent event) throws IOException {
        if (choice_two_correct) {
            currentScore++;
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(c);
            //call changequestion method with new riddle based on current score
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
        } else {
            currentScore--;
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
            changeQuestion(riddleLib.select(currentScore));
//            changeButtons(b);
            //call changequestion method with new riddle based on current score
            if (currentScore >= score_to_win) {
                WinScreenController winScreen = new WinScreenController();
                winScreen.switchToWinScreen(event);
            }
        } else {
            currentScore--;
            //call changequestion method with new riddle based on current score
        }
    }

    public static void goToWinScreen() {
//        if (currentScore >= score_to_win) {
//            WinScreenController winScreen = new WinScreenController();
//            winScreen.switchToWinScreen();
//        }
    }
}
