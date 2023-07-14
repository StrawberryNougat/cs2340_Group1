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
    public int battleBoats = 5;

    public Board(boolean enemy, EventHandler<? super MouseEvent> handler) {
        this.opponent = enemy;
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
                Adjacent.add(getBlock((int)q.getX(), (int)q.getY()));
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
    public boolean positionShip(BattleBoat boat, int x, int y) {
        if (availablePositionBattleBoat(boat, x, y)) {
            int size = boat.type;
            if (boat.vertical) {
                for (int i = y; i < y + size; i++) {
                    Block block = getBlock(x, i);
                    block.battleboat = boat;
                    if (!opponent) {
                        block.setFill(Color.YELLOW);
                        block.setStroke(Color.WHITE);
                    }
                }
            } else {
                for (int i = x; i < x + size; i++) {
                    Block block = getBlock(i, y);
                    block.battleboat = boat;
                    if (!opponent) {
                        block.setFill(Color.YELLOW);
                        block.setStroke(Color.WHITE);
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean availablePositionBattleBoat(BattleBoat battleboat, int x, int y) {
        int size = battleboat.type;
        if (battleboat.vertical) {
            for (int i = y; i < y + size; i++) {
                if (!isExistencePoint(x, i)) {
                    return false;
                }
                Block block = getBlock(x, i);
                if (block.battleboat != null) {
                    return false;
                }
                for (Block adjacent : getAdjacent(x, i)) {
                    if (!isExistencePoint(x, i)) {
                        return false;
                    }
                    if (adjacent.battleboat != null) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = x; i < x + size; i++) {
                if (!isExistencePoint(i, y)) {
                    return false;
                }
                Block block = getBlock(i, y);
                if (block.battleboat != null) {
                    return false;
                }
                for(Block adjacent: getAdjacent(i, y)){
                    if(!isExistencePoint(i,y)) {
                        return false;
                    }
                    if(adjacent.battleboat != null){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public class Block extends Rectangle {
        public int x, y;
        public BattleBoat battleboat = null;
        public boolean wasHit = false;

        private Board board;

        public Block(int x, int y, Board board) {
            super(30,30);
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
                    board.battleBoats--;
                }
                return true;
            }
            return false;
        }

    }
}
