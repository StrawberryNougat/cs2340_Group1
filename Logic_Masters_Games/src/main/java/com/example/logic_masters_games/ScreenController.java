package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ScreenController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Image apple = new Image("Apple_Sprite.png");

    public Image cat = new Image("cat_sprite.png");

    public Image bunny = new Image("Bunny_Sprite.png");



    @FXML
    TextField usernameInput;

    @FXML
    ChoiceBox<String> gameOneChoiceBox = new ChoiceBox<String>();
    @FXML
    ChoiceBox<String> gameTwoChoiceBox = new ChoiceBox<String>();
    @FXML
    ChoiceBox<String> gameThreeChoiceBox = new ChoiceBox<String>();

    @FXML
    ChoiceBox<String> gameOneDifficultyBox = new ChoiceBox<String>();
    private String[] sprites = {"bunny", "cat", "apple"};

    private String[] difficulties = {"easy", "normal", "hard"};

    public void startGameOne (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game1-start-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startGameTwo (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game2-start-screen.fxml"));
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

    public void goToGameTwoInitialization (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game2-initialization-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToGameThreeInitialization (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game3-initialization-screen.fxml"));
        stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void goToGameOne (ActionEvent event) throws IOException { //fun button code. Yay.
        String username = usernameInput.getText();
        if (!username.isBlank() && !gameOneChoiceBox.getValue().isBlank()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game1-game-screen.fxml"));
            root = loader.load();
            GameOneController gameOneController = loader.getController();
            gameOneController.displayUsername(username);
            if (gameOneChoiceBox.getValue().equals("bunny")) {
                gameOneController.showSprite(bunny);
            }
            if (gameOneChoiceBox.getValue().equals("cat")) {
                gameOneController.showSprite(cat);
            }
            if (gameOneChoiceBox.getValue().equals("apple")) {
                gameOneController.showSprite(apple);
            }


            //Parent root = FXMLLoader.load(getClass().getResource("game1-game-screen.fxml"));
            stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void goToGameTwo (ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        if (!username.isBlank() && !gameTwoChoiceBox.getValue().isBlank()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game2-game-screen.fxml"));
            root = loader.load();
            GameTwoController gameTwoController = loader.getController();
            gameTwoController.displayUsername(username);
            if (gameTwoChoiceBox.getValue().equals("bunny")) {
                gameTwoController.showSprite(bunny);
            }
            if (gameTwoChoiceBox.getValue().equals("cat")) {
                gameTwoController.showSprite(cat);
            }
            if (gameTwoChoiceBox.getValue().equals("apple")) {
                gameTwoController.showSprite(apple);
            }


            //Parent root = FXMLLoader.load(getClass().getResource("game2-game-screen.fxml"));
            stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void goToGameThree (ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        if (!username.isBlank() && !gameThreeChoiceBox.getValue().isBlank()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game3-game-screen.fxml"));
            root = loader.load();
            Game3Controller gameThreeController = loader.getController();
            gameThreeController.displayUsername(username);
            if (gameThreeChoiceBox.getValue().equals("bunny")) {
                gameThreeController.showSprite(bunny);
            }
            if (gameThreeChoiceBox.getValue().equals("cat")) {
                gameThreeController.showSprite(cat);
            }
            if (gameThreeChoiceBox.getValue().equals("apple")) {
                gameThreeController.showSprite(apple);
            }


            //Parent root = FXMLLoader.load(getClass().getResource("game2-game-screen.fxml"));
            stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameOneChoiceBox.getItems().addAll(sprites);
        gameTwoChoiceBox.getItems().addAll(sprites);
        gameThreeChoiceBox.getItems().addAll(sprites);
        gameOneDifficultyBox.getItems().addAll(difficulties);
    }

}
