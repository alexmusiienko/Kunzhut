package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
<<<<<<<Updated upstream
import android.support.v4.app.FragmentActivity;

import static android.app.PendingIntent.getActivity;

import android.view.View;
=======
        >>>>>>>Stashed changes
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.hello_fragment, container, false);
    }

    protected void onViewCreated(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        <<<<<<<Updated upstream
        replaceFragment(new HelloFragment());

        LetsStarButtom = (Button) view.findViewById(R.id.button);
        LetsStarButtom.setOnClickListener(new View.OnClickListener());
        {

            @Override
            public void onClick ( final View view){

            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.showFragment(new ChatFragmant());
        }
        }
        =======

        showFragment(new HelloFragment());
        >>>>>>>Stashed changes
    }

    public void replaceFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.commit();
    }

    <<<<<<<Updated upstream

    public void showFragment(Fragment fragment) {

        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        mainActivity.showFragment(new ChatFragment());
    }

    public void goToPreviousFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentManager fm = getActivity().supportFragmentManager();

        fm.popBackStack();
    }
}
=======
        }


        >>>>>>>Stashed changes
