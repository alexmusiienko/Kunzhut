package com.example.alexm.kunzhutproject;

enum StepType {
    NAME, KIDS, VISA_TYPE, PURPOSE, FAMILY_IN_COUNTRY, PASSPORT_NUMBER
}

public class Step {

    static StepType CURRENT = StepType.NAME;

    static void nextStep() {
        CURRENT = StepType.values()[CURRENT.ordinal() + 1];
    }

    static String getQuestion() {
        switch (CURRENT) {
            case NAME:
                return "Hello, Introduce yourself.";
            case VISA_TYPE:
                return "Choose your visa type";
            default:
                return "See you later";
        }
    }
}