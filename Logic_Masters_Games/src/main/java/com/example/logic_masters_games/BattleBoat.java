import javafx.scene.Parent;

public class BattleBoat extends Parent {
    public int type;
    public boolean vertical = true;

    private int strength;

    public BattleBoat(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        strength = type;
    }
}
