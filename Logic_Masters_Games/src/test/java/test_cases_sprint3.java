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
        ticTacToeReferee.opponentPositions.add(1);
        ticTacToeReferee.opponentPositions.add(2);
        ticTacToeReferee.opponentPositions.add(3);
        ticTacToeReferee.opponentPositions.add(4);
        ticTacToeReferee.playerPositions.add(5);
        ticTacToeReferee.playerPositions.add(6);
        ticTacToeReferee.playerPositions.add(7);
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
    @Test
    public void testMarkBoard() { //Mei
        //to test if the method only generates random numbers within range of 1 - 9,
        // and output 1 if the generated random number exceeds the range.
        TicTacToePlayer check = new TicTacToePlayer();

        assertTrue(check.markBoard(1) == 1);
        assertTrue(check.markBoard(9) == 9);
        assertTrue(check.markBoard(10) == 1);
        assertTrue(check.markBoard(0) == 1);
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

        java.util.ArrayList<List> check = new ArrayList<>();

        check.add(tRow);
        check.add(mRow);
        check.add(bRow);
        check.add(lCol);
        check.add(mCol);
        check.add(rCol);
        check.add(dia1);
        check.add(dia2);

        assertEquals(rf.winConditions,check);
    }

    //just a suggestion: someone else can do another test on markBoard.
    // to test whether the output number match the randomly generated number.
    // you can do this by calling markBoard() on each from 1-9, in the assertTrue/Equal().
    // delete this comment if you find it useless or after you have done it haha
    // Mei
}

