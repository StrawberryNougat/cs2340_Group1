package com.example.logic_masters_games;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
//import javafx.scene.control.Cell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Board extends Parent {
    private VBox horizontal = new VBox();
    private boolean opponent = false;
    public int ships = 7;

    public Board(boolean enemy, EventHandler<? super MouseEvent> handler) {
        this.opponent = opponent;
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 10; x++) {
                Block c = new Block(x,y,this);
                c.setOnMouseClicked(handler);
                row.getChildren().add(c);
            }
            horizontal.getChildren().add(row);
        }
        this.getChildren().add(horizontal);
    }
    public Block getBlock(int x, int y) {
        return (Block)((HBox)horizontal.getChildren().get(y)).getChildren().get(x);
    }
    private Block[] getAdjacent(int x, int y) {
        Point2D[] points = new Point2D[] {
                new Point2D(x -1, y),
                new Point2D(x+1, y),
                new Point2D(x, y -1),
                new Point2D(x, y + 1)
        };
        List<Block> Adjacent = new ArrayList<Block>();

        for (Point2D q: points) {
            if (isExistencePoint(q)) {
                Adjacent.add(getBlock(int)q.getX(), (int)q.getY()));
            }
        }
        return Adjacent.toArray(new Block[0]);
    }
    private boolean isExistencePoint(Point2D point) {
        return isExistencePoint(point.getX(),point.getY());
    }
    private boolean isExistencePoint(double x, double y) {
        return x>= 0 && x < 10 && y >= 0 && y <10;
    }
    public class Block extends Rectangle {
        public int x, y;
        public BattleBoat battleboat = null;
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
                if (!battleboat.hasSurvived()) {
                    board.battleboat--;
                }
                return true;
            }
            return false;
        }
    }
}
