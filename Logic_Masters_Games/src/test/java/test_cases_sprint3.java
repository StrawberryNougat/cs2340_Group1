import com.example.logic_masters_games.*;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import org.testfx.framework.junit.ApplicationTest;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test_cases_sprint3 {
    @Test
    public void test_check_winner_tie() {  //Eleanor
        TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
        //board is full, but no win condition
        ticTacToeReferee.opponentPositions.add(1);
        ticTacToeReferee.opponentPositions.add(5);
        ticTacToeReferee.opponentPositions.add(7);
        ticTacToeReferee.opponentPositions.add(6);
        ticTacToeReferee.playerPositions.add(3);
        ticTacToeReferee.playerPositions.add(4);
        ticTacToeReferee.playerPositions.add(2);
        ticTacToeReferee.playerPositions.add(8);
        ticTacToeReferee.playerPositions.add(9);
        String check = ticTacToeReferee.checkWinner();
        assertEquals(check, "Tie!");
    }

    @Test
    public void test_check_winner_opponent() {  //Eleanor
        TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
        ticTacToeReferee.opponentPositions.add(1);
        ticTacToeReferee.opponentPositions.add(2);
        ticTacToeReferee.opponentPositions.add(3);
        String check = ticTacToeReferee.checkWinner();
        assertEquals(check, "Opponent won!");
    }

    @Test
    public void test_check_winner_player() {  //Armaan
        TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
        ticTacToeReferee.playerPositions.add(1);
        ticTacToeReferee.playerPositions.add(2);
        ticTacToeReferee.playerPositions.add(3);
        String check = ticTacToeReferee.checkWinner();
        assertEquals(check, "You won!");
    }
/*
    @Test
    public void testAllPositionsOfMarkBoard() { //Armaan
        TicTacToePlayer check = new TicTacToePlayer();
        assertTrue(check.markBoard(1) == 1);
        assertTrue(check.markBoard(2) == 2);
        assertTrue(check.markBoard(3) == 3);
        assertTrue(check.markBoard(4) == 4);
        assertTrue(check.markBoard(5) == 5);
        assertTrue(check.markBoard(6) == 6);
        assertTrue(check.markBoard(7) == 7);
        assertTrue(check.markBoard(8) == 8);
        assertTrue(check.markBoard(9) == 9);
    }
*/
    @Test
    public void testWinningConditions() { //Mei
        //check if the player positions really match one of the winning condition when the player has won.
        TicTacToeReferee check = new TicTacToeReferee();

        check.playerPositions.add(1);
        check.playerPositions.add(5);
        check.playerPositions.add(9);

        assertEquals(check.checkWinner(), "You won!");
        assertEquals(check.playerPositions, check.winConditions.get(6));
    }

    @Test
    public void referee_constructor() { //Mei
        TicTacToeReferee rf = new TicTacToeReferee();
        List tRow = Arrays.asList(1, 2, 3);
        List mRow = Arrays.asList(4, 5, 6);
        List bRow = Arrays.asList(7, 8, 9);

        List lCol = Arrays.asList(1, 4, 7);
        List mCol = Arrays.asList(2, 5, 8);
        List rCol = Arrays.asList(3, 6, 9);

        List dia1 = Arrays.asList(1, 5, 9);
        List dia2 = Arrays.asList(3, 5, 7);

        assertEquals(rf.winConditions, tRow);
        assertEquals(rf.winConditions, mRow);
        assertEquals(rf.winConditions, bRow);

        assertEquals(rf.winConditions, lCol);
        assertEquals(rf.winConditions, mCol);
        assertEquals(rf.winConditions, rCol);

        assertEquals(rf.winConditions, dia1);
        assertEquals(rf.winConditions, dia2);
    }
}

