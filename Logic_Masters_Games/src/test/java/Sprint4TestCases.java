public class Sprint4TestCases {
    @Test
    public void destroyTest() {
        //Testing the destroy method with a non-null BattleBoat
        Board board = new Board();
        Board.Block block = controller.new Block(1, 1, board);
        block.battleboat = new BattleBoat(1, true);

        //Successful destroy should return true
        assertTrue(block.destroy());
    }

    @Test
    public void activeAfterRefresh() {
        Game3Controller controller = new Game3Controller();
        controller.refresh();
        assertTrue(active);

    }

    @Test
    public void destroyNullTest() {
        //Testing the destroy method with null BattleBoat
        Board board = new Board();
        Board.Block block = controller.new Block(1, 1, board);

        //Failed destroy should return false
        assertFalse(block.destroy());
    }
}