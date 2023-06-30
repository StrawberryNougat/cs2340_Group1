package com.example.logic_masters_games;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends TicTacToePlayer {
    @Override
    public void playItsMove(ArrayList<Button> buttons, Button b, TicTacToeReferee ref) {
        // Step 0: Create a Java Random object in order to randomize inputs.
        Random rand = new Random();
        // Step 1: Get input randomly (an int from 1 to 9).
        int intForComputerPlayer = rand.nextInt(9) + 1;
        // Step 2: If corresponding board spots are already taken, try a new random number until success.
        while ((ref.playerPositions.contains(intForComputerPlayer) ||
                ref.opponentPositions.contains(intForComputerPlayer))) {
            intForComputerPlayer = rand.nextInt(9) + 1;
        }
        // Step 3: Mark input spot with "o" and disable that button.
        buttons.get(intForComputerPlayer).setText("o");
        buttons.get(intForComputerPlayer).setDisable(true);
        // Store this input to opponent's list of played moves.
        ref.opponentPositions.add(intForComputerPlayer);
    }
}
