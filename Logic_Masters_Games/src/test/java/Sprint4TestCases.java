import com.example.logic_masters_games.BattleBoat;
import com.example.logic_masters_games.Board;
import com.example.logic_masters_games.Game3Controller;
import javafx.scene.paint.Color;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Sprint4TestCases {
    @Test
    public void destroyTest() { //Aishi
        //Testing the destroy method with a non-null BattleBoat

        Board board = new Board(false, null);
        Board.Block block = board.new Block(1, 1, board);
        block.battleboat = new BattleBoat(1, true);

        //Successful destroy should return true
        assertTrue(block.destroy());
    }

    @Test
    public void activeAfterRefresh() { //Aishi
        Game3Controller controller = new Game3Controller();
        controller.setShipsToAdd(0);
        controller.setOpponentBoard(new Board(true, null));
        controller.setPlayerBoard(new Board(false, null));
        controller.refreshGame();
        assertTrue(controller.getActive());

    }

    @Test
    public void destroyNullTest() { //Aishi
        //Testing the destroy method with null BattleBoat
        Board board = new Board(false, null);
        Board.Block block = board.new Block(1, 1, board);

        //Failed destroy should return false
        assertFalse(block.destroy());
    }

    @Test
    public void checkHitIsNullAfterClear() { // Eleanor
        Game3Controller game3Controller = new Game3Controller();
        game3Controller.setShipsToAdd(0);
        game3Controller.setOpponentBoard(new Board(true, null));
        game3Controller.setPlayerBoard(new Board(false, null));
        game3Controller.getPlayerBoard().getBlock(1,1).wasHit = true;
        game3Controller.getOpponentBoard().getBlock(1,1).wasHit = true;
        game3Controller.getOpponentBoard().clearBoard();
        game3Controller.getPlayerBoard().clearBoard();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                assertEquals(game3Controller.getPlayerBoard().getBlock(x, y).wasHit, false);
                assertEquals(game3Controller.getOpponentBoard().getBlock(x, y).wasHit, false);

            }
        }
//        game3Controller.refreshGame();
        assertEquals(game3Controller.getOpponentBoard().battleBoats, 5);
    }

    @Test
    public void boardClearCheckNoShips() { //Eleanor
        Game3Controller game3Controller = new Game3Controller();
        game3Controller.setShipsToAdd(0);
        game3Controller.setOpponentBoard(new Board(true, null));
        game3Controller.setPlayerBoard(new Board(false, null));
        game3Controller.getPlayerBoard().getBlock(1,1).battleboat = new BattleBoat(5, true);
        game3Controller.getOpponentBoard().getBlock(1,1).battleboat = new BattleBoat(5, true);
        game3Controller.getOpponentBoard().clearBoard();
        game3Controller.getPlayerBoard().clearBoard();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                assertEquals(game3Controller.getPlayerBoard().getBlock(x, y).battleboat, null);
                assertEquals(game3Controller.getOpponentBoard().getBlock(x, y).battleboat, null);

            }
        }
    }
}
