package com.example.logic_masters_games;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Cell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends Parent {
    private VBox horizontal = new VBox();
    private boolean opponent = false;
    public int ships = 7;

    public Board(boolean enemy, EventHandler<? super MouseEvent> handler) {
        this.opponent = opponent;
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 10; x++) {
                Cell c = new Cell();
                c.setOnMouseClicked(handler);
                row.getChildren().add(c);
            }
            horizontal.getChildren().add(row);
        }
        this.getChildren().add(horizontal);
    }
    public class Block extends Rectangle {
        public int x, y;
        public Battleboat battleboat = null;
        public boolean wasHit = false;

        private Board board;

        public Block(int x, int y, Board board) {
            super(45,45);
            this.x = x;
            this.y = y;
            this.board =  board;
            setFill(Color.AQUAMARINE);
            setStroke(Color.BLACK);
        }
        public boolean destroy() {
            wasHit = true;
            setFill(Color.BLUEVIOLET);
            if (battleboat != null) {
                battleboat.kaboom();
                setFill(Color.DARKRED);
                if (!battleboat.isSurvived()) {
                    board.battleboat--;
                }
                return true;
            }
            return false;
        }
    }
}
