package com.example.logic_masters_games;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class HumanPlayer4x4 extends TicTacToePlayer4x4 {
    @Override
    public void playItsMove(ArrayList<Button> buttons, Button b, TicTacToeReferee4x4 ref) {
        int intForHumanPlayer = 0;
        // Find which button it was among button1 ~ button9.
        for (int i = 0; i < buttons.size(); i++) {
            if (b.equals(buttons.get(i))) {
                // When found, mark it with "x" and disable that button.
                intForHumanPlayer = i;
                buttons.get(i).setText("x");
                buttons.get(i).setDisable(true);
                break;
            }
        }
        // Store this input to a player's list of played moves.
        ref.playerPositions.add(intForHumanPlayer);
    }
}
