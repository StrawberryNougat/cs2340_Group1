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
}

