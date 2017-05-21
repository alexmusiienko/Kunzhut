package com.example.alexm.kunzhutproject;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by savin on 17.05.2017.
 */

public class GeneralFragment extends Fragment {

    protected Toolbar toolbar;

    protected void showBackButton() {
        toolbar = (Toolbar) getView().findViewById(R.id.master_toolbar);

        final MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar supportActionBar = activity.getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                activity.goToPreviousFragment();
            }
        });
    }
}
