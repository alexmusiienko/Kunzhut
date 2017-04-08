package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;


/**
 * Created by polis on 24.03.2017.
 */

public class SelectionFragment extends Fragment {
    private Button button1, button2, button3, button4, button5, help_button;
    HelpFragment hp_but = new HelpFragment();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
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
                mainActivity.showFragment(chatFragmant, true);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new ChatFragmant(), true);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new ChatFragmant(), true);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new ChatFragmant(), true);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new ChatFragmant(), true);
            }
        });

        help_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                hp_but.setTitle("Ola!");
                hp_but.setDescription("Ola!");
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new HelpFragment(), true);
            }
        });
        return view;
    }
}