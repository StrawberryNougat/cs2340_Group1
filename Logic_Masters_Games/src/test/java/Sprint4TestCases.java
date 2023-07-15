import com.example.logic_masters_games.BattleBoat;

import java.lang.reflect.Field;

public class Sprint4TestCases {
    @Test
    public void destroyTest() { //Aishi
        //Testing the destroy method with a non-null BattleBoat
        Board board = new Board();
        Board.Block block = controller.new Block(1, 1, board);
        block.battleboat = new BattleBoat(1, true);

        //Successful destroy should return true
        assertTrue(block.destroy());
    }

    @Test
    public void activeAfterRefresh() { //Aishi
        Game3Controller controller = new Game3Controller();
        controller.refresh();
        assertTrue(active);

    }

    @Test
    public void destroyNullTest() { //Aishi
        //Testing the destroy method with null BattleBoat
        Board board = new Board();
        Board.Block block = controller.new Block(1, 1, board);

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
}
