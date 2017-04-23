package com.example.alexm.kunzhutproject;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {

    public static List<Question> qetStudentVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже обрали торговий центр?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));

        return questions;
    }

    public static List<Question> qetWorkingVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ваша фірма забронювала місце у готелі для Вас?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));

        return questions;
    }

    public static List<Question> qetBusinessVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("У вас є діти?"));
        questions.add(new Question(""));

        return questions;
    }

    public static List<Question> qetExursionVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви забронювали собі місце у готелі?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));

        return questions;
    }

    public static List<Question> qetShoppingVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже обрали торговий центр?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));

        return questions;
    }
}
