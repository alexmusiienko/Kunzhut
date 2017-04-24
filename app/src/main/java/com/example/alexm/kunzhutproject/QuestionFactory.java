package com.example.alexm.kunzhutproject;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {

    public static List<Question> qetStudentVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже подорожували до Америки?"));
        questions.add(new Question("У вас є медичне страхування?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));
        questions.add(new Question("Ви маєте міжнародний студентський квиток?"));

        return questions;
    }

    public static List<Question> qetWorkingVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже подорожували до Америки?"));
        questions.add(new Question("У вас є медичне страхування?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));
        questions.add(new Question("Ви подбали про місце ночівлі?"));
        questions.add(new Question("У вас є діти?"));

        return questions;
    }

    public static List<Question> qetBusinessVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже подорожували до Америки?"));
        questions.add(new Question("У вас є медичне страхування?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));
        questions.add(new Question("Ви подбали про місце ночівлі?"));
        questions.add(new Question("У вас є діти?"));

        return questions;
    }

    public static List<Question> qetExursionVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже подорожували до Америки?"));
        questions.add(new Question("У вас є медичне страхування?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));
        questions.add(new Question("Ви подбали про місце ночівлі?"));
        questions.add(new Question("У вас є діти?"));

        return questions;
    }

    public static List<Question> qetShoppingVisa() {
        final List<Question> questions = new ArrayList<>();

        questions.add(new Question("Вам є повних 18 р.?"));
        questions.add(new Question("Ви вже подорожували до Америки?"));
        questions.add(new Question("У вас є медичне страхування?"));
        questions.add(new Question("Ви маєте квитки туди і назад?"));
        questions.add(new Question("Ви подбали про місце ночівлі?"));
        questions.add(new Question("У вас є діти?"));
        questions.add(new Question("Ви вже обрали торговий центр?"));

        return questions;
    }
}

