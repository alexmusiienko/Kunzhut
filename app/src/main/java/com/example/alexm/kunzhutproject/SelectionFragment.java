package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;

import java.util.List;

public class SelectionFragment extends Fragment {

    private void click_listening(){
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;
        mainActivity.showFragment(new ChatFragmant(), true);
    }

    HelpFragment hp_but = new HelpFragment();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Button button1;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button help_button;
        View view = inflater.inflate(R.layout.selection_fragment, container, false);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        help_button = (Button) view.findViewById(R.id.help_button);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                    FragmentActivity activity = getActivity();
                    MainActivity mainActivity = (MainActivity) activity;
                    ChatFragmant chatFragmant = new ChatFragmant();

                    /*
                    //SETER DOESN'T EXIST
                    final List<Question> questions = QuestionFactory.qetStudentVisa();
                    chatFragmant.getStudentVisa(studentVisa);
                    */

                    mainActivity.showFragment(chatFragmant, true);
                }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                ChatFragmant chatFragmant = new ChatFragmant();

                    /*
                    //SETER DOESN'T EXIST
                    final List<Question> questions = QuestionFactory.qetWorkingVisa();
                    chatFragmant.setWorkingVisa(workingVisa);
                    */

                mainActivity.showFragment(chatFragmant, true);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                ChatFragmant chatFragmant = new ChatFragmant();

                    /*
                    //SETER DOESN'T EXIST
                    final List<Question> questions = QuestionFactory.qetBusinessVisa();
                    chatFragmant.setBusinessVisa(businessVisa);
                    */

                mainActivity.showFragment(chatFragmant, true);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                ChatFragmant chatFragmant = new ChatFragmant();

                    /*
                    //SETER DOESN'T EXIST
                    final List<Question> questions = QuestionFactory.qetExcursionVisa();
                    chatFragmant.setExcursionVisa(excursionVisa);
                    */

                mainActivity.showFragment(chatFragmant, true);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                ChatFragmant chatFragmant = new ChatFragmant();

                    /*
                    //SETER DOESN'T EXIST
                    final List<Question> questions = QuestionFactory.qetShoppingVisa();
                    chatFragmant.setShoppingVisa(shoppingVisa);
                    */

                mainActivity.showFragment(chatFragmant, true);
            }
        });
        help_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                hp_but.setTitle("Ola!");
                hp_but.setDescription("Ola!");
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(hp_but, true);
            }
        });
        return view;
    }
}