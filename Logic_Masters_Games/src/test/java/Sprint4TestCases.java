import com.example.logic_masters_games.BattleBoat;


import java.lang.reflect.Field;


import com.example.logic_masters_games.Board;
import com.example.logic_masters_games.Game3Controller;
import javafx.scene.paint.Color;
import org.junit.Test;

import static javafx.scene.paint.Color.AQUAMARINE;
import static javafx.scene.paint.Color.YELLOW;
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

    @Test //Taewoon
    public void testKaboom() throws NoSuchFieldException, IllegalAccessException {
        // Create a BattleBoat with type 3 and vertical orientation
        BattleBoat battleBoat = new BattleBoat(3, true);

        // Access the private field 'strength' using reflection
        Field strengthField = BattleBoat.class.getDeclaredField("strength");
        strengthField.setAccessible(true);

        // Get the initial value of 'strength'
        int initialStrength = (int) strengthField.get(battleBoat);

        // Call kaboom method once
        battleBoat.kaboom();

        // Get the updated value of 'strength'
        int updatedStrength = (int) strengthField.get(battleBoat);

        // Check if the strength is decremented by 1
        assertEquals(initialStrength - 1, updatedStrength);
    }

    @Test //Taewoon
    public void testHasSurvived() throws NoSuchFieldException, IllegalAccessException {
        // Create a BattleBoat with type 2 and horizontal orientation
        BattleBoat battleBoat = new BattleBoat(2, false);

        // Access the private field 'strength' using reflection
        Field strengthField = BattleBoat.class.getDeclaredField("strength");
        strengthField.setAccessible(true);

        // Set the value of 'strength' to 1
        strengthField.set(battleBoat, 1);

        // Check if the BattleBoat has initially survived
        assertTrue(battleBoat.hasSurvived());

        // Call kaboom method once
        battleBoat.kaboom();

        // Check if the BattleBoat has not survived anymore
        assertFalse(battleBoat.hasSurvived());
    }


        @Test
        public void checkHitIsNullAfterClear () { // Eleanor
            Game3Controller game3Controller = new Game3Controller();
            game3Controller.setShipsToAdd(0);
            game3Controller.setOpponentBoard(new Board(true, null));
            game3Controller.setPlayerBoard(new Board(false, null));
            game3Controller.getPlayerBoard().getBlock(1, 1).wasHit = true;
            game3Controller.getOpponentBoard().getBlock(1, 1).wasHit = true;
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
        public void boardClearCheckNoShips () { //Eleanor
            Game3Controller game3Controller = new Game3Controller();
            game3Controller.setShipsToAdd(0);
            game3Controller.setOpponentBoard(new Board(true, null));
            game3Controller.setPlayerBoard(new Board(false, null));
            game3Controller.getPlayerBoard().getBlock(1, 1).battleboat = new BattleBoat(5, true);
            game3Controller.getOpponentBoard().getBlock(1, 1).battleboat = new BattleBoat(5, true);
            game3Controller.getOpponentBoard().clearBoard();
            game3Controller.getPlayerBoard().clearBoard();
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    assertEquals(game3Controller.getPlayerBoard().getBlock(x, y).battleboat, null);
                    assertEquals(game3Controller.getOpponentBoard().getBlock(x, y).battleboat, null);

                }
            }

        }


        @Test
        public void testValidAvailableBattleBoatPosition() { //Armaan
        Board board = new Board(false, null);
        BattleBoat testBattleBoat = new BattleBoat(3, false);
        boolean test= board.availablePositionBattleBoat(testBattleBoat,2, 3);
        assertTrue(test, "This is a valid position");
    }
    @Test
    public void testInvalidAvailableBattleBoatPosition() { //Armaan
        Board board = new Board(false, null);
        BattleBoat testBattleBoat = new BattleBoat(3, true);
        boolean test = board.availablePositionBattleBoat(testBattleBoat,-1, 2);
        assertFalse(test, "This is a invalid position");
    }

    @Test
    public void testColorChangeAtShipPositionsVertical() { //Mei
        BattleBoat boat = new BattleBoat(2, true);
        //Before the ship of size 2 is placed on the board, the colour should be Aquamarine.
        Board board = new Board(false, null);
        Board.Block block1 = board.getBlock(5, 5);
        Board.Block block2 = board.getBlock(5, 6);
        assertEquals(AQUAMARINE, block1.getFill());
        assertEquals(AQUAMARINE, block2.getFill());
        //Colour change when the ship is placed.
        board.positionShip(boat, 5, 5);
        assertEquals(YELLOW, block1.getFill());
        assertEquals(YELLOW, block2.getFill());
        //Blocks other than the blocks with ships remain aquamarine colour. Few examples:
        Board.Block blockOther1 = board.new Block(6, 5, board);
        Board.Block blockOther2 = board.new Block(7, 5, board);
        assertNotEquals(YELLOW, blockOther1.getFill());
        assertNotEquals(YELLOW, blockOther2.getFill());

    }

    @Test
    public void testColorChangeAtShipPositionsHorizontal() { //Mei
        BattleBoat boat = new BattleBoat(2, false);
        //Before the ship of size 2 is placed on the board, the colour should be Aquamarine.
        Board board = new Board(false, null);
        Board.Block block1 = board.getBlock(5, 5);
        Board.Block block2 = board.getBlock(6, 5);
        assertEquals(AQUAMARINE, block1.getFill());
        assertEquals(AQUAMARINE, block2.getFill());
        //Colour change when the ship is placed.
        board.positionShip(boat, 5, 5);
        assertEquals(YELLOW, block1.getFill());
        assertEquals(YELLOW, block2.getFill());
        //Blocks other than the blocks with ships remain aquamarine colour. Few examples:
        Board.Block blockOther1 = board.new Block(5, 6, board);
        Board.Block blockOther2 = board.new Block(5, 4, board);
        assertNotEquals(YELLOW, blockOther1.getFill());
        assertNotEquals(YELLOW, blockOther2.getFill());

    }


}
