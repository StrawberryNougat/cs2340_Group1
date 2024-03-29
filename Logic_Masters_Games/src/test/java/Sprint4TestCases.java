import com.example.logic_masters_games.BattleBoat;


import java.lang.reflect.Field;


import com.example.logic_masters_games.Board;
import com.example.logic_masters_games.Game3Controller;
import javafx.scene.paint.Color;
import org.junit.Test;

import static javafx.scene.paint.Color.AQUAMARINE;
import static javafx.scene.paint.Color.YELLOW;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        public void testKaboom() {  //Taewoon
            BattleBoat battleBoat = new BattleBoat(3, true);
            int initialStrength = battleBoat.getStrength();
            battleBoat.kaboom();
            int updatedStrength = battleBoat.getStrength();
            assertEquals(initialStrength - 1, updatedStrength);
        }
        @Test
        public void testHasSurvived() { //Taewoon
            BattleBoat battleBoat = new BattleBoat(2, false);

            // Assert that the BattleBoat initially has the correct strength
            assertEquals(2, battleBoat.getStrength());

            // Assert that the BattleBoat initially reports as survived
            assertTrue(battleBoat.hasSurvived());

            // Call kaboom() method to decrement the strength by 1
            battleBoat.kaboom();

            // Assert that the strength is now 1
            assertEquals(1, battleBoat.getStrength());

            // Assert that the BattleBoat still reports as survived
            assertTrue(battleBoat.hasSurvived());

            // Call kaboom() method again to decrement the strength by 1
            battleBoat.kaboom();

            // Assert that the strength is now 0
            assertEquals(0, battleBoat.getStrength());

            // Assert that the BattleBoat no longer reports as survived
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

    @Test
    public void testBoatConstructor() { //Mei
        BattleBoat boat = new BattleBoat(6, false);
        assertEquals(6, boat.type);
        assertEquals(false, boat.vertical);
        assertEquals(6, boat.getStrength());
    }

    @Test
    public void testPositionShipBoatSize0() { //Aaron
        // Create a game board.
        Board myBoard = new Board(false, null);
        //---------------------------------------------------------------------
        // Create a vertical Battleboat of size 0.
        BattleBoat myBoatV = new BattleBoat(0, true);
        // Position the boat wherever, for example, at (3, 6).
        myBoard.positionShip(myBoatV, 3, 6);
        // Assert that everywhere is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
        //---------------------------------------------------------------------
        // Create a horizontal Battleboat of size 0.
        BattleBoat myBoatH = new BattleBoat(0, false);
        // Position the boat wherever, for example, at (4, 3).
        myBoard.positionShip(myBoatH, 4, 3);
        // Assert that everywhere is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
    }
    @Test
    public void testPositionShipBoatSize1() { //Aaron
        // Create a game board.
        Board myBoard = new Board(false, null);
        //---------------------------------------------------------------------
        // Create a vertical Battleboat of size 1.
        BattleBoat myBoatV = new BattleBoat(1, true);
        // Position the boat wherever, for example, at (3, 6).
        myBoard.positionShip(myBoatV, 3, 6);
        Board.Block block_to_be_filled = myBoard.getBlock(3, 6);
        // Assert that (3, 6) is indeed filled with boat color (yellow).
        assertEquals(YELLOW, block_to_be_filled.getFill());
        // Assert that everywhere else is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (y == 6 && x == 3) {
                    continue;
                }
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
        //---------------------------------------------------------------------
        // Clear the board.
        myBoard.clearBoard();
        //---------------------------------------------------------------------
        // Create a horizontal Battleboat of size 1.
        BattleBoat myBoatH = new BattleBoat(1, false);
        // Position the boat wherever, for example, at (3, 6).
        myBoard.positionShip(myBoatH, 3, 6);
        Board.Block block_to_be_filled2 = myBoard.getBlock(3, 6);
        // Assert that (3, 6) is indeed filled with boat color (yellow).
        assertEquals(YELLOW, block_to_be_filled2.getFill());
        // Assert that everywhere else is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (y == 6 && x == 3) {
                    continue;
                }
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
    }

    @Test
    public void testPositionShipBoatSizeMax() { //Aaron
        // Create a game board.
        Board myBoard = new Board(false, null);
        //---------------------------------------------------------------------
        // Create a vertical Battleboat of size 10.
        BattleBoat myBoatV = new BattleBoat(10, true);
        // Position the boat wherever, for example, at (2, 0).
        myBoard.positionShip(myBoatV, 2, 0);
        // Assert that (2, 0) ~ (2, 9) are all indeed filled with boat color (yellow).
        for (int y = 0; y < 10; y++) {
                assertEquals(YELLOW, myBoard.getBlock(2, y).getFill());
        }
        // Assert that everywhere else is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == 2) {
                    continue;
                }
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
        //---------------------------------------------------------------------
        // Clear the board.
        myBoard.clearBoard();
        //---------------------------------------------------------------------
        // Create a horizontal Battleboat of size 10.
        BattleBoat myBoatH = new BattleBoat(10, false);
        // Position the boat wherever, for example, at (0, 4).
        myBoard.positionShip(myBoatH, 0, 4);
        // Assert that (0, 4) ~ (9, 4) are all indeed filled with boat color (yellow).
        for (int x = 0; x < 10; x++) {
            assertEquals(YELLOW, myBoard.getBlock(x, 4).getFill());
        }
        // Assert that everywhere else is still filled with sea color (aquamarine).
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (y == 4) {
                    continue;
                }
                assertEquals(AQUAMARINE, myBoard.getBlock(x, y).getFill());
            }
        }
    }
}
