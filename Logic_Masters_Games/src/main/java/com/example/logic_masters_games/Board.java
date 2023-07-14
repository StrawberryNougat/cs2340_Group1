package com.example.logic_masters_games;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Cell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
}
