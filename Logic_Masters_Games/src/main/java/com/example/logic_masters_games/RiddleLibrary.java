package com.example.logic_masters_games;

import java.util.Stack;

public class RiddleLibrary {



    private int difficultyThresholdEM;

    private int difficultyThresholdMH;

    public java.util.Stack<Riddle> availableRiddlesEasy = new Stack<Riddle>();

    public java.util.Stack<Riddle> availableRiddlesMed = new Stack<Riddle>();

    public java.util.Stack<Riddle> availableRiddlesHard = new Stack<Riddle>();

    public RiddleLibrary(int EM, int MH, Riddle[] easy, Riddle[] normal, Riddle[] hard) {
        this.difficultyThresholdEM = EM;
        this.difficultyThresholdMH = MH;
        for (Riddle i:  easy) {
            this.availableRiddlesEasy.push(i);
        }
        for (Riddle i:  normal) {
            this.availableRiddlesMed.push(i);
        }
        for (Riddle i: hard) {
            this.availableRiddlesHard.push(i);
        }

    }

    public void addRiddle(int level, Riddle newRiddle) {
        if (level < difficultyThresholdEM) {
            availableRiddlesEasy.push(newRiddle);
        } else if (level >= difficultyThresholdEM &&
                level <= difficultyThresholdMH) {
            availableRiddlesMed.push(newRiddle);
        } else {
            availableRiddlesHard.push(newRiddle);
        }
    }

    public Riddle select(int currScore) {
        if (areRiddlesRemaining(currScore)) {
            if (currScore < difficultyThresholdEM) {
                return availableRiddlesEasy.pop();
            } else if (currScore >= difficultyThresholdEM &&
                    currScore <= difficultyThresholdMH) {
                return availableRiddlesMed.pop();
            } else {
                return availableRiddlesHard.pop();
            }
        } else {
            throw new java.util.NoSuchElementException("Hey Libby change this - this is a test hi future me");
        }

    }

    public Riddle selectByDifficultyLevel(int level) {
        // When user selects Easy, level will be passed in as 0.
        // When user selects Medium, level will be passed in as 1.
        // When user selects Hard, level will be passed in as 2.
        if (level == 0) {
            return availableRiddlesEasy.pop();
        } else if (level == 1) {
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
