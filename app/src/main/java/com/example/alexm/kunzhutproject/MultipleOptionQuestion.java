package com.example.alexm.kunzhutproject;

import java.util.List;

public class MultipleOptionQuestion {
    private List<String> answerOptions;

    private int answerIndex;

    public MultipleOptionQuestion (String questionTitle){
        super(questionTitle);
    }
    public List<String> getAnswerOptions(){
        return answerOptions;
    }
    public void setAnswerIndex(int answerIndex){
        this.answerIndex = answerIndex;
    }
}
