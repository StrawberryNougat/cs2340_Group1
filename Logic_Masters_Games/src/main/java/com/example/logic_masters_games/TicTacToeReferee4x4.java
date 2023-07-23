package com.example.logic_masters_games;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeReferee4x4 {

    public ArrayList<Integer> playerPositions = new ArrayList<>();
    public ArrayList<Integer> opponentPositions = new ArrayList<>();
    public ArrayList<List> winConditions = new ArrayList<>();

    public TicTacToeReferee4x4() {
        // rows
        List firstRow = Arrays.asList(1, 2, 3, 4);
        List secondRow = Arrays.asList(5, 6, 7, 8);
        List thirdRow = Arrays.asList(9, 10, 11, 12);
        List fourthRow = Arrays.asList(13, 14, 15, 16);
        // columns
        List firstCol = Arrays.asList(1, 5, 9, 13);
        List secondCol = Arrays.asList(2, 6, 10, 14);
        List thirdCol = Arrays.asList(3, 7, 11, 15);
        List fourthCol = Arrays.asList(4, 8, 12, 16);
        // diagonals
        List dia1 = Arrays.asList(1, 6, 11, 16);
        List dia2 = Arrays.asList(4, 7, 10, 13);

        winConditions.add(firstCol);
        winConditions.add(firstRow);
        winConditions.add(secondCol);
        winConditions.add(secondRow);
        winConditions.add(thirdCol);
        winConditions.add(thirdRow);
        winConditions.add(fourthCol);
        winConditions.add(fourthRow);
        winConditions.add(dia1);
        winConditions.add(dia2);
    }

    public String checkWinner() {
        // Check if one side wins.
        for (List cond : winConditions) {
            if (playerPositions.containsAll(cond)) {
                return "You won!";
            } else if (opponentPositions.containsAll(cond)) {
                return "Opponent won!";
            }
        }
        // Check if it is a tie (e.g. board is full).
        if (playerPositions.size() + opponentPositions.size() == 16) {
            return "Tie!";
        }
        return "";
    }

    public void clearBoard(ArrayList<Button> buttons) {
        for (int i = 1; i < buttons.size(); i++) {
            buttons.get(i).setText("");
            buttons.get(i).setDisable(false);
        }
        playerPositions.clear();
        opponentPositions.clear();
    }
}