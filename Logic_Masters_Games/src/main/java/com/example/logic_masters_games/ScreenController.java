package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ScreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
}
