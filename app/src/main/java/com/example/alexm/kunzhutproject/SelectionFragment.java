package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class SelectionFragment extends Fragment {

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
                navigateToChat(QuestionFactory.getStudentVisaQuestions());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                navigateToChat(QuestionFactory.getWorkingVisaQuestions());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                navigateToChat(QuestionFactory.getBusinessVisaQuestions());
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                navigateToChat(QuestionFactory.getExursionVisaQuestions());
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                navigateToChat(QuestionFactory.getShoppingVisaQuestions());
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

    private void navigateToChat(final List<Question> questions) {
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        final ChatFragment fragment = new ChatFragment();
        fragment.setQuestions(questions);

        mainActivity.showFragment(fragment, true);
    }
}