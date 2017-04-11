package com.example.alexm.kunzhutproject;

public class BooleanQuestion extends Question{

    private boolean answer;

    public void setAnswer(boolean answer){
        this.answer = answer;
    }

    public BooleanQuestion(String s) {
        super(questionTitle);
    }
}
