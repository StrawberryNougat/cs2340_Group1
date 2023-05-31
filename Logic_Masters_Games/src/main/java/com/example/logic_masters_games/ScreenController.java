package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ScreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField usernameInput;

    public void startGameOne (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game1-start-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startGameTwo (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game-2-start-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startGameThree (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game3-start-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goBackToWelcomeScreen (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToGameOneInitialization (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game1-initialization-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToGameOne (ActionEvent event) throws IOException { //fun button code. Yay.
        String username = usernameInput.getText();
        if (!username.isBlank()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game1-game-screen.fxml"));
            root = loader.load();
            GameOneController gameOneController = loader.getController();
            gameOneController.displayUsername(username);

            //Parent root = FXMLLoader.load(getClass().getResource("game1-game-screen.fxml"));
            stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
