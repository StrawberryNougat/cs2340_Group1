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

    @FXML
    ChoiceBox<String> gameTwoDifficultyBox = new ChoiceBox<String>();

    @FXML
    ChoiceBox<String> gameThreeDifficultyBox = new ChoiceBox<>();

    @FXML
    ChoiceBox<String> boardChoiceBox = new ChoiceBox<>();
    private String[] sprites = {"bunny", "cat", "apple"};

    private String[] difficulties = {"easy", "normal", "hard"};

    private String[] boards = {"3x3", "4x4"};

    Riddle startingEasy = new Riddle(
            "David’s parents have three sons: Snap, Crackle, and what’s the name of the third son?",
            "Easy",
            "David",
            "Snap",
            "Crackle");


    Riddle startingMedium = new Riddle(
            "I shave every day, but my beard stays the same. What am I?",
            "Med",
            "A Barber",
            "A Magician",
            "A Carpenter");


    Riddle startingHard = new Riddle(
            "What can fill a room but takes up no space?",
            "Hard",
            "Light",
            "Dust",
            "Energy");

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
        if (!username.isBlank() && !gameOneChoiceBox.getValue().isBlank() && !gameOneDifficultyBox.getValue().isBlank()) {
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

            if (gameOneDifficultyBox.getValue().equals("easy")) {
                gameOneController.changeScore(0);
                gameOneController.changeWinningScore(2);
                gameOneController.changeQuestion(startingEasy);


            }
            if (gameOneDifficultyBox.getValue().equals("normal")) {
                gameOneController.changeScore(0);
                gameOneController.changeWinningScore(5);
                gameOneController.changeQuestion(startingMedium);


            }
            if (gameOneDifficultyBox.getValue().equals("hard")) {
                gameOneController.changeScore(0);
                gameOneController.changeWinningScore(8);
                gameOneController.changeQuestion(startingHard);


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
        if (!username.isBlank() && !gameTwoChoiceBox.getValue().isBlank() && !boardChoiceBox.getValue().isBlank()) {
            FXMLLoader loader;
            if (boardChoiceBox.getValue().equals("3x3")) {
                loader = new FXMLLoader(getClass().getResource("game2-game-screen.fxml"));
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
                if (gameTwoDifficultyBox.getValue().equals("easy")) {
                    gameTwoController.changeNumLives(3);
                    gameTwoController.changeNumLivesText(3);


                }
                if (gameTwoDifficultyBox.getValue().equals("normal")) {
                    gameTwoController.changeNumLives(2);
                    gameTwoController.changeNumLivesText(2);


                }
                if (gameTwoDifficultyBox.getValue().equals("hard")) {
                    gameTwoController.changeNumLives(1);
                    gameTwoController.changeNumLivesText(1);


                }
            } else {
                loader = new FXMLLoader(getClass().getResource("game2-game-screen-4x4.fxml"));
                root = loader.load();
                GameTwoController4x4 gameTwoController = loader.getController();
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
                if (gameTwoDifficultyBox.getValue().equals("easy")) {
                    gameTwoController.changeNumLives(3);
                    gameTwoController.changeNumLivesText(3);


                }
                if (gameTwoDifficultyBox.getValue().equals("normal")) {
                    gameTwoController.changeNumLives(2);
                    gameTwoController.changeNumLivesText(2);


                }
                if (gameTwoDifficultyBox.getValue().equals("hard")) {
                    gameTwoController.changeNumLives(1);
                    gameTwoController.changeNumLivesText(1);


                }
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
            root = gameThreeController.createContent(event);
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
            if (gameThreeDifficultyBox.getValue().equals("easy")) {
                gameThreeController.setNumLives(3);

            }
            if (gameThreeDifficultyBox.getValue().equals("normal")) {

                gameThreeController.setNumLives(2);

            }
            if (gameThreeDifficultyBox.getValue().equals("hard")) {

                gameThreeController.setNumLives(1);

            }

            root = gameThreeController.createContent(event);
            //Parent root = FXMLLoader.load(getClass().getResource("game2-game-screen.fxml"));
            stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(gameThreeController.createContent(event));
            stage.setScene(scene);
            gameThreeController.stage = this.stage;
            stage.show();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameOneChoiceBox.getItems().addAll(sprites);
        gameTwoChoiceBox.getItems().addAll(sprites);
        gameThreeChoiceBox.getItems().addAll(sprites);
        gameOneDifficultyBox.getItems().addAll(difficulties);
        gameTwoDifficultyBox.getItems().addAll(difficulties);
        gameThreeDifficultyBox.getItems().addAll(difficulties);
        boardChoiceBox.getItems().addAll(boards);
    }

}
