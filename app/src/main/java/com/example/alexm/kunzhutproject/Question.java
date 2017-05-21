package com.example.alexm.kunzhutproject;

public class Question {

    private String questionTitle;

    private boolean isAnswered;

    public Question(final String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
