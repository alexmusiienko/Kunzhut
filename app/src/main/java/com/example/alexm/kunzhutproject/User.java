package com.example.alexm.kunzhutproject;

/**
 * Created by alexm on 4/10/2017.
 */

enum VisaType {
    STUDENT, WORK

}

public class User {

    String name = "";
    VisaType visaType;

    private User() { }
    
    public static final User CURRENT = new User();
}
