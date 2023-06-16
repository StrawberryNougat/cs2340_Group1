package com.example.logic_masters_games;

public class RiddleLibrary {

    private String category;

    private int difficultyThresholdEM;

    private int difficultyThresholdMH;

    private java.util.Stack<Riddle> availableRiddlesEasy;

    private java.util.Stack<Riddle> availableRiddlesMed;

    private java.util.Stack<Riddle> availableRiddlesHard;

    public RiddleLibrary(String category, int EM, int MH) {
        this.category = category;
        this.difficultyThresholdEM = EM;
        this.difficultyThresholdMH = MH;
    }

    public addRiddle(int level, Riddle newRiddle) {
        if (level < difficultyThresholdEM) {
            return availableRiddlesEasy.push(newRiddle);
        } else if (level >= difficultyThresholdEM &&
                level <= difficultyThresholdMH) {
            return availableRiddlesMed.push(newRiddle);
        } else {
            return availableRiddlesHard.push(newRiddle);
        }
    }
    public Riddle select(int currScore) {
        if (currScore < difficultyThresholdEM) {
            return availableRiddlesEasy.pop();
        } else if (currScore >= difficultyThresholdEM &&
                currScore <= difficultyThresholdMH) {
            return availableRiddlesMed.pop();
        } else {
            return availableRiddlesHard.pop();
        }
    }

    public boolean areRiddlesRemaining(int currScore) {
        if (currScore < difficultyThresholdEM && availableRiddlesEasy.empty()) {
            return false;
        } else if (currScore >= difficultyThresholdEM &&
                currScore <= difficultyThresholdMH && availableRiddlesMed.empty()) {
            return false;
        } else if (currScore > difficultyThresholdMH && availableRiddlesHard.empty()){
            return false;
        } else {
            return true;
        }
    }
}
