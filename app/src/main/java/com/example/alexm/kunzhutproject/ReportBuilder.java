package com.example.alexm.kunzhutproject;

import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {

    public static List<String> createStepsFromAnswers(final List<Question> questions,
                                                      VisaType visaType) {

        switch (visaType) {
            case STUDENT:
                return createStepsForStudentsVisa(questions);
            case WORKING:
                return createStepsForWorkingVisa(questions);
            case BUSINESS:
                return createStepsForBusinessVisa(questions);
            case EXCURSION:
                return createStepsForExcursionVisa(questions);
            case SHOPPING:
                return createStepsForShoppingVisa(questions);
            default:
                return null;
        }
    }

    private static List<String> createStepsForStudentsVisa(final List<Question> questions) {
        List<String> steps = new ArrayList<>();

        BooleanQuestion ageQuestion = (BooleanQuestion) questions.get(0);
        if (ageQuestion.isAnswerPositive()) {
            steps.add("Перевірте, чи не вийшов термін дії Вашого закордонного паспорта.");
        } else {
            steps.add("Подбайте про нотаріально затверджений дозвіл від батьків про перетин кордону.");
        }

        BooleanQuestion travelToUsaQuestion = (BooleanQuestion) questions.get(0);
        if (travelToUsaQuestion.isAnswerPositive()) {
            steps.add("Вітаємо, Ви знайомі із процедурою оформлення візи.");
        } else {
            steps.add("Нічого страшного, наш додаток допоможе Вам.");
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

        BooleanQuestion studentPassQuestion = (BooleanQuestion) questions.get(0);
        if (studentPassQuestion.isAnswerPositive()) {
            steps.add("Під час подорожі скористайтеся пільговими знижками на різноманітні квитки/послуги.");
        } else {
            steps.add("Нічого, виготовте його для наступної подорожі, аби скористатися пільговими послугами.");
        }
        return steps;
    }

    private static List<String> createStepsForWorkingVisa(final List<Question> questions) {
        List<String> steps = new ArrayList<>();

        BooleanQuestion ageQuestion = (BooleanQuestion) questions.get(0);
        if (ageQuestion.isAnswerPositive()) {
            steps.add("Перевірте, чи не вийшов термін дії Вашого закордонного паспорта.");
        } else {
            steps.add("Ви не можете здійснити подорож за робочою візою. Оберіть інши тип візи.");
        }

        BooleanQuestion maritalStatusQuestion = (BooleanQuestion) questions.get(0);
        if (maritalStatusQuestion.isAnswerPositive()) {
            steps.add("Гаразд, переходьте до наступного кроку.");
        } else {
            steps.add("Подбайте, аби діти були вписані у Ваш закордонний паспорт.");
        }

        BooleanQuestion travelToUsaQuestion = (BooleanQuestion) questions.get(0);
        if (travelToUsaQuestion.isAnswerPositive()) {
            steps.add("Гаразд, Ви знайомі із процедурою оформлення візи.");
        } else {
            steps.add("Нічого страшного, наш додаток допоможе Вам.");
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

        return steps;
    }

    private static List<String> createStepsForBusinessVisa(final List<Question> questions) {
        List<String> steps = new ArrayList<>();

        BooleanQuestion maritalStatusQuestion = (BooleanQuestion) questions.get(0);
        if (maritalStatusQuestion.isAnswerPositive()) {
            steps.add("Гаразд, переходьте до наступного кроку.");
        } else {
            steps.add("Подбайте, аби діти були вписані у Ваш закордонний паспорт.");
            }

        BooleanQuestion travelToUsaQuestion = (BooleanQuestion) questions.get(0);
        if (travelToUsaQuestion.isAnswerPositive()) {
            steps.add("Вітаємо, Ви знайомі із процедурою оформлення візи.");
        } else {
            steps.add("Нічого страшного, наш додаток допоможе Вам.");
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

        return steps;
    }

    private static List<String> createStepsForExcursionVisa(final List<Question> questions) {
        List<String> steps = new ArrayList<>();

        BooleanQuestion maritalStatusQuestion = (BooleanQuestion) questions.get(0);
        if (maritalStatusQuestion.isAnswerPositive()) {
            steps.add("Гаразд, переходьте до наступного кроку.");
        } else {
            steps.add("Подбайте, аби діти були вписані у Ваш закордонний паспорт.");
        }

        BooleanQuestion travelToUsaQuestion = (BooleanQuestion) questions.get(0);
        if (travelToUsaQuestion.isAnswerPositive()) {
            steps.add("Вітаємо, Ви знайомі із процедурою оформлення візи.");
        } else {
            steps.add("Нічого страшного, наш додаток допоможе Вам.");
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

        return steps;
    }

    private static List<String> createStepsForShoppingVisa(final List<Question> questions) {
        List<String> steps = new ArrayList<>();

        BooleanQuestion maritalStatusQuestion = (BooleanQuestion) questions.get(0);
        if (maritalStatusQuestion.isAnswerPositive()) {
            steps.add("Гаразд, переходьте до наступного кроку.");
        } else {
            steps.add("Подбайте, аби діти були вписані у Ваш закордонний паспорт.");
        }

        BooleanQuestion travelToUsaQuestion = (BooleanQuestion) questions.get(0);
        if (travelToUsaQuestion.isAnswerPositive()) {
            steps.add("Вітаємо, Ви знайомі із процедурою оформлення візи.");
        } else {
            steps.add("Нічого страшного, наш додаток допоможе Вам.");
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

        return steps;
    }
}
