package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HelloFragment extends Fragment {
    private Button LetsStarButtom;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hello_fragment, container, false);
        LetsStarButtom = (Button) view.findViewById(R.id.button);
        LetsStarButtom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new SelectionFragment(), false);
            }
        });
        return view;
    }
}
