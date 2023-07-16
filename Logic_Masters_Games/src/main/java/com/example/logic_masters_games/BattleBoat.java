package com.example.logic_masters_games;

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

    public void kaboom() {
        strength--;
    }

    public boolean hasSurvived() {
        return strength > 0;
    }

    public int getStrength() {
        return strength;
    }
}
