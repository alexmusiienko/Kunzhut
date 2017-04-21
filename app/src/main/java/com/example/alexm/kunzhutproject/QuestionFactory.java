package com.example.alexm.kunzhutproject;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {

    public static List<Question> qetBusinessVisa(){
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Are you 18 yo?"));
        questions.add(new Question("Do you have child?"));
        questions.add(new Question(""));

        return questions;
    }

    public static List<Question> qetShoppingVisa(){
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Are you 18 yo?"));
        questions.add(new Question("Have you already choosed your shopping mall?"));
        questions.add(new Question("Do you have two ways tickets?"));

        return questions;
    }

    public static List<Question> qetExursionVisa(){
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Are you 18 yo?"));
        questions.add(new Question("Have you already booked a hotel?"));
        questions.add(new Question("Do you have two ways tickets?"));

        return questions;
    }
}
