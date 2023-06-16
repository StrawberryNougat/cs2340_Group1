package com.example.logic_masters_games;

public class Riddle {
    public String content;
    private String difficulty;
    public String right_answer;

    public String wrong_answer1;

    public String wrong_answer2;

    public Riddle(String content, String difficulty, String right_answer, String wrong_answer1, String wrong_answer2) {
        this.content = content;
        this.difficulty = difficulty;
        this.right_answer = right_answer;
        this.wrong_answer1 = wrong_answer1;
        this.wrong_answer2 = wrong_answer2;
    }
}
