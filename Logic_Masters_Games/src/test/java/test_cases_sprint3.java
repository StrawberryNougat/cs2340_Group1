import com.example.logic_masters_games.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        //check if the positions really match one of the winning condition (dia1) when the player/opponent has won.
        TicTacToeReferee check = new TicTacToeReferee();

        check.playerPositions.add(1);
        check.playerPositions.add(5);
        check.playerPositions.add(9);

        assertEquals(check.playerPositions, check.winConditions.get(6));

        check.playerPositions.clear();

        check.opponentPositions.add(1);
        check.opponentPositions.add(5);
        check.opponentPositions.add(9);

        assertEquals(check.opponentPositions, check.winConditions.get(6));
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

        assertEquals(tRow, rf.winConditions.get(0));
        assertEquals(mRow, rf.winConditions.get(1));
        assertEquals(bRow, rf.winConditions.get(2));

        assertEquals(lCol, rf.winConditions.get(3));
        assertEquals(mCol, rf.winConditions.get(4));
        assertEquals(rCol, rf.winConditions.get(5));

        assertEquals(dia1, rf.winConditions.get(6));
        assertEquals(dia2, rf.winConditions.get(7));
    }
    @Test
    public void clearCheck() {
        TicTacToeReferee ref = new TicTacToeReferee();
        
        ref.playerPositions.add(1);
        ref.playerPositions.add(5);
        ref.playerPositions.add(9);
        ref.opponentPositions.add(2);
        ref.opponentPositions.add(4);
        ref.opponentPositions.add(6);
      
        ArrayList<Button> buttons = new ArrayList<>();
        ref.clearBoard(buttons);
        assertEquals(0, ref.playerPositions.size());
        assertEquals(0, ref.opponentPositions.size());
    }
    @Test
    public void TicTacToeRefereeConstructor() { //Taewoon
        TicTacToeReferee ref = new TicTacToeReferee();

        assertEquals(ref.playerPositions.isEmpty(),true);
        assertEquals(ref.opponentPositions.isEmpty(), true);
    }
    /*
    public void TicTacToe
    */
}

