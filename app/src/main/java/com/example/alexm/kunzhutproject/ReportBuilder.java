package com.example.alexm.kunzhutproject;

import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {

    public static List<String> createStepsFromAnswers(final List<Question> questions) {

        List<String> steps = new ArrayList<>();

        BooleanQuestion ageQuestion = (BooleanQuestion) questions.get(0);
        if (ageQuestion.isAnswerPositive()) {
        steps.add("---");
        } else {
            steps.add("Подбайте про нотаріально затверджений дозвіл від батьків про перетин кордону.");
        }

        BooleanQuestion maritalStatusQuestion = (BooleanQuestion) questions.get(0);
        if (maritalStatusQuestion.isAnswerPositive()) {
            steps.add("---");
        } else {
            steps.add("Подбайте, аби діти були вписані у Ваш закордонний паспорт.");
        }

        BooleanQuestion insuranceQuestion = (BooleanQuestion) questions.get(0);
        if (insuranceQuestion.isAnswerPositive()) {
            steps.add("Подбайте про наявність копій угоди про страхове забезпечення.");
        } else {
            steps.add("Оформіть медичне страхування, аби уникнути нещасних випадків.");
        }

        BooleanQuestion ticketsQuestion = (BooleanQuestion) questions.get(0);
        if (ticketsQuestion.isAnswerPositive()) {
            steps.add("Перевірте своє бронювання та подбайте про наявність квитків на час подорожі.");
        } else {
            steps.add("Придбайте квитки за допомогою онлайн-сервісів/авіакас.");
        }

        BooleanQuestion hotelQuestion = (BooleanQuestion) questions.get(0);
        if (hotelQuestion.isAnswerPositive()) {
            steps.add("Роздрукуйте підтвердження бронювання номеру у готелі/хостелі.");
        } else {
            steps.add("Подбайте про ночівлю заздалегідь - забронюйте номер у готелі/хостелі");
        }

        BooleanQuestion shoppingMallQuestion = (BooleanQuestion) questions.get(0);
        if (shoppingMallQuestion.isAnswerPositive()) {
            steps.add("Бажаємо вдалих покупок!");
        } else {
            steps.add("Задля Вашої зручності оберіть торговий центр/складіть перелік магазинів.");
        }

        BooleanQuestion studentPassQuestion = (BooleanQuestion) questions.get(0);
        if (studentPassQuestion.isAnswerPositive()) {
            steps.add("Під час подорожі скористайтеся пільговими знижками на різноманітні квитки/послуги.");
        } else {
            steps.add("---");
        }

        return steps;

    }
}
