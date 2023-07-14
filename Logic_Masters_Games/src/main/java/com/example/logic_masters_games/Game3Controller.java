package com.example.logic_masters_games;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class Game3Controller  {
    private int numLives;
    @FXML
    Label usernameDisplay;

    @FXML
    ImageView gameThreeSprite;

    @FXML
    Label gameThreeLivesDisplay;


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

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);
        root.setRight(newText("RIGHT SIDEBAR - CONTROLS"));
        opponentBoard - new Board(true, event -> {
            if (!active)
                return
            Block block = (Block) event.getSource();

            if (block.isHit)
                return

            opponentTurn = !block.destroy();

            if (opponentBoard.battleBoats == 0) {
                System.out.println("YOU WIN!");
                System.exit(0);
            }

            if (opponentTurn)
                opponentMove();
        });

        playerBoard = new Board(false, event -> {
            if (active)
                return;

            Block block = (Block) event.getSource();
            if (playerBoad.positionShip(new BattleBoat(shipsToAdd, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToAdd == 0) {
                    startGame();
                }
            }
        });

        Vbox vbox = new VBox(50, opponentBoard, playerBoard);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        return root;
    }


}
