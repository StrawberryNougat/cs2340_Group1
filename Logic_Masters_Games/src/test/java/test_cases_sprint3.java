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
    public void testSpecificWinningConditionForPlayer() {  //Armaan
        //Checks one of the multiple winning conditions for the player when they win.
        //For this test case, we will check and verify positions 1, 2 and 3 on the TicTacToe Board
        TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
        ticTacToeReferee.playerPositions.add(1);
        ticTacToeReferee.playerPositions.add(2);
        ticTacToeReferee.playerPositions.add(3);
        String check = ticTacToeReferee.checkWinner();
        assertEquals(check, "You won!");
    }

    @Test
    public void testSpecificWinningConditionForOpponent() {  //Armaan
        //Checks one of the multiple winning conditions for the opponent when they win.
        //For this test case, we will check and verify positions 3,5 and 7 on the TicTacToe Board
        TicTacToeReferee ticTacToeReferee = new TicTacToeReferee();
        ticTacToeReferee.opponentPositions.add(3);
        ticTacToeReferee.opponentPositions.add(5);
        ticTacToeReferee.opponentPositions.add(7);
        String check = ticTacToeReferee.checkWinner();
        assertEquals(check, "Opponent won!");
    }

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
    public void clearCheck() { //Aishi
        //Tests the clearBoard method of TicTacToeReferee
        TicTacToeReferee ref = new TicTacToeReferee();
        
        //Updates playerPositions & opponentPositions
        ref.playerPositions.add(1);
        ref.playerPositions.add(5);
        ref.playerPositions.add(9);
        ref.opponentPositions.add(2);
        ref.opponentPositions.add(4);
        ref.opponentPositions.add(6);
        
        //Clears game board
        ArrayList<Button> buttons = new ArrayList<>();
        ref.clearBoard(buttons);
        
        //Checks if playerPositions & opponentPostitions have been reset
        assertEquals(0, ref.playerPositions.size());
        assertEquals(0, ref.opponentPositions.size());
    }
    
    @Test
    public void numLivesTest() { //Aishi
        //Tests the changeNumLives of GameTwoController
        GameTwoController game = new GameTwoController();
        
        //Changes numLives twice
        game.changeNumLives(5);
        game.changeNumLives(4);
        
        //Checks numLives for latest update
        assertEquals(4, game.getNumLives());
    }

    @Test
    public void TicTacToeRefereeConstructorPositionsEmpty() { //Taewoon
        TicTacToeReferee ref = new TicTacToeReferee();

        assertEquals(ref.playerPositions.isEmpty(),true);
        assertEquals(ref.opponentPositions.isEmpty(), true);
    }
    @Test
    public void testScoreStartsAtFive() { //Taewoon
        GameTwoController controller = new GameTwoController();
        int expectedScore = 5;
        int actualScore = controller.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void test_checkWinner_board_full_human_wins() { //Aaron
        // Tests the case where human player wins and board gets full at the same time.
        TicTacToeReferee myReferee = new TicTacToeReferee();
        myReferee.playerPositions.add(3);
        myReferee.opponentPositions.add(2);
        myReferee.playerPositions.add(4);
        myReferee.opponentPositions.add(6);
        myReferee.playerPositions.add(5);
        myReferee.opponentPositions.add(8);
        myReferee.playerPositions.add(1);
        myReferee.opponentPositions.add(9);
        // Player's last move fills up the board.
        myReferee.playerPositions.add(7);
        // Check if the board did get full.
        assertEquals(myReferee.playerPositions.size() + myReferee.opponentPositions.size(), 9);
        // Player made the 3-5-7 diagonal line, should win.
        String check = myReferee.checkWinner();
        assertEquals(check, "You won!");
    }

    @Test
    public void test_checkWinner_board_full_opponent_wins() { //Aaron
        // Tests the case where opponent wins and board gets full at the same time.
        TicTacToeReferee myReferee = new TicTacToeReferee();
        myReferee.opponentPositions.add(5);
        myReferee.playerPositions.add(3);
        myReferee.opponentPositions.add(1);
        myReferee.playerPositions.add(9);
        myReferee.opponentPositions.add(6);
        myReferee.playerPositions.add(4);
        myReferee.opponentPositions.add(8);
        myReferee.playerPositions.add(7);
        // Opponent's last move fills up the board.
        myReferee.opponentPositions.add(2);
        // Check if the board did get full.
        assertEquals(myReferee.playerPositions.size() + myReferee.opponentPositions.size(), 9);
        // Opponent made the 2-5-8 vertical line, should win.
        String check = myReferee.checkWinner();
        assertEquals(check, "Opponent won!");
    }
}

