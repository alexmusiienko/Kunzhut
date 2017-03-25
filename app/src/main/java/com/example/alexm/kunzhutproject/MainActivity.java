package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}

    protected void onViewCreate(){
        setContentView(R.layout.activity_main);
        replaceFragment(new HelloFragment());
    }

    public void replaceFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.commit();
    }

    //LAST TASKS
    public void showFragment(Fragment fragment) {

        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        mainActivity.showFragment(new ExampleFragment());
    }

    public void goToPreviousFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentManager fm = getActivity().supportFragmentManager();

        fm.popBackStack();
    }
}
}
