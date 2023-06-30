package com.example.logic_masters_games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeReferee {

    public java.util.ArrayList<Integer> playerPositions = new java.util.ArrayList<>();
    public java.util.ArrayList<Integer> opponentPositions = new java.util.ArrayList<>();
    public java.util.ArrayList<List> winConditions = new ArrayList<>();

    public TicTacToeReferee() {
        // rows
        List tRow = Arrays.asList(1, 2, 3);
        List mRow = Arrays.asList(4, 5, 6);
        List bRow = Arrays.asList(7, 8, 9);
        // columns
        List lCol = Arrays.asList(1, 4, 7);
        List mCol = Arrays.asList(2, 5, 8);
        List rCol = Arrays.asList(3, 6, 9);
        // diagonals
        List dia1 = Arrays.asList(1, 5, 9);
        List dia2 = Arrays.asList(3, 5, 7);

        winConditions.add(tRow);
        winConditions.add(mRow);
        winConditions.add(bRow);
        winConditions.add(lCol);
        winConditions.add(mCol);
        winConditions.add(rCol);
        winConditions.add(dia1);
        winConditions.add(dia2);
    }

    public String checkWinner() {
        // Check if it is a tie (e.g. board is full).
        if (playerPositions.size() + opponentPositions.size() == 9) {
            return "Tie!";
        }
        // Check if one side wins.
        for (List cond : winConditions) {
            if (playerPositions.containsAll(cond)) {
                return "You won!";
            } else if (opponentPositions.containsAll(cond)) {
                return "Opponent won!";
            }
        }
        return "";
    }
}