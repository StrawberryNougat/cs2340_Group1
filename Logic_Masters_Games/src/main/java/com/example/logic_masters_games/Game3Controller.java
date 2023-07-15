package com.example.logic_masters_games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.example.logic_masters_games.Board.Block;
import com.example.logic_masters_games.Board;

public class Game3Controller {
    private int numLives;
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameThreeSprite;

    @FXML
    Label gameThreeLivesDisplay;

    public Stage stage;
    public Scene scene;
    private Parent root;

    private int score = 7;


    private Board opponentBoard, playerBoard;
    private int shipsUsed;
    private boolean active = false;

    private int shipsToAdd = 5;
    private boolean opponentTurn = false;



    public void displayUsername(String username) {
        usernameDisplay.setText("Username: " + username);
    }

    public void showSprite(Image gameSprite) {
        gameThreeSprite.setImage(gameSprite);
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
        gameThreeLivesDisplay.setText("Lives: " + numLives);
    }

    private Random random = new Random();

    public Parent createContent(ActionEvent e) throws IOException {
//        Label gameThreeLivesDisplay = new Label();
        gameThreeLivesDisplay.setAlignment(Pos.TOP_RIGHT);

//        gameThreeLivesDisplay.setText("Lives: " + numLives);
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);
        root.setRight(gameThreeLivesDisplay);
        root.setTop(usernameDisplay);
        root.setLeft(gameThreeSprite);
        opponentBoard = new Board(true, event -> {
            if (!active) {
                return;
            }
            Block block = (Block) event.getSource();

            if (block.wasHit) {
                return;
            }
            opponentTurn = !block.destroy();

            if (opponentBoard.battleBoats == 0) {

                try {
                    WinScreenController winScreen = new WinScreenController();
                    winScreen.switchToWinScreenGm3(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

            if (opponentTurn) {
                try {
                    opponentMove(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        playerBoard = new Board(false, event -> {
            if (active)
                return;
            Board.Block block = (Board.Block) event.getSource();
            if (playerBoard.positionShip(new BattleBoat(shipsToAdd, event.getButton() == MouseButton.PRIMARY), block.x, block.y)) {
                if (--shipsToAdd == 0) {
                    refreshGame();
                }
            }
        });

        VBox vbox = new VBox(50, opponentBoard, playerBoard);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        return root;
    }

    private void refreshGame() {
        int shipNum = 5;

        while (shipNum > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (opponentBoard.positionShip(new BattleBoat(shipNum, Math.random() < .5), x, y)) {
                shipNum--;
            }
        }
        this.active = true;
    }

    private void opponentMove(ActionEvent e) throws IOException {
        while(opponentTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Block block = playerBoard.getBlock(x, y);
            if (block.wasHit) {
                continue;
            }
            opponentTurn = block.destroy();
            if (playerBoard.battleBoats == 0) {
                numLives--;
                score--;
                gameThreeLivesDisplay.setText("Lives: " + numLives);
                if (numLives == 0) {
                    goToLoseScreen(e);
                } else {
//                    this.root = createContent(e);
                    opponentBoard.clearBoard();
                    playerBoard.clearBoard();
//                    Block b = (Block) e.getSource();
                    this.shipsToAdd = 5;
                    opponentBoard.battleBoats = 5;

                    playerBoard.battleBoats = 5;

                    this.active = false;

                }
            }
        }
    }

    public void resetBoards(ActionEvent e) throws IOException {
        opponentBoard = new Board(true, event -> {
            if (!active) {
                return;
            }
            Block block = (Block) event.getSource();

            if (block.wasHit) {
                return;
            }
            opponentTurn = !block.destroy();

            if (opponentBoard.battleBoats == 0) {

                try {
                    WinScreenController winScreen = new WinScreenController();
                    winScreen.switchToWinScreenGm3(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

            if (opponentTurn) {
                try {
                    opponentMove(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        playerBoard = new Board(false, event -> {
            if (active)
                return;

            Board.Block block = (Board.Block) event.getSource();
            if (playerBoard.positionShip(new BattleBoat(shipsToAdd, event.getButton() == MouseButton.PRIMARY), block.x, block.y)) {
                if (--shipsToAdd == 0) {
                    refreshGame();
                }
            }
        });

        VBox vbox = new VBox(50, opponentBoard, playerBoard);
        vbox.setAlignment(Pos.CENTER);
    }

    public void goToLoseScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_three_lose_screen.fxml"));
        root = loader.load();
        stage = new Stage();//(Stage) ((Node) event.getSource()).getScene().getWindow();
        GameThreeLoseController gameThreeLoseController = loader.getController();
        gameThreeLoseController.setGameTwoLoseText(score);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void goToWinScreen(ActionEvent event) throws IOException {
        WinScreenController winScreen = new WinScreenController();
        winScreen.switchToWinScreen(event);
    }
}
