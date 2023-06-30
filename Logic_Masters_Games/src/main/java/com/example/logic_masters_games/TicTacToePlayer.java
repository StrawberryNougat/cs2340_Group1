package com.example.logic_masters_games;
import java.util.Random;

public class TicTacToePlayer {
    private Random rand = new Random();
    public int markBoard(int pos) {

        int returner = 1;
        switch (pos) {
            case 1:
                returner = 1;
                break;
            case 2:
                returner = 2;
                break;
            case 3:
                returner = 3;
                break;
            case 4:
                returner = 4;
                break;
            case 5:
                returner = 5;
                break;
            case 6:
                returner = 6;
                break;
            case 7:
                returner = 7;
                break;
            case 8:
                returner = 8;
                break;
            case 9:
                returner = 9;
                break;
            default:
                break;
        }
        return returner;
    }
}