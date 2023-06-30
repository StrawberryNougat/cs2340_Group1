package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;
//package com.example.logic_masters_games;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;


public class GameTwoLoseController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label gameTwoLoseText;
    public void setGameTwoLoseText(int score) {
        gameTwoLoseText.setText("You lost all your lives - but you final score is... " + score);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGameTwoLoseText(0);


    }
    public void switchToLoseScreen(ActionEvent event) throws IOException {


    }
}
