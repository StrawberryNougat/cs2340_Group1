package com.example.sprint1.Logic_Masters_Games.src.main.java.com.example.logic_masters_games;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class WinScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToStartScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome-screen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
