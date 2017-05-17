package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelpFragment extends GeneralFragment {
    private String title;
    private String description;

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {this.description = description;}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showBackButton();

        final TextView titleView = (TextView) view.findViewById(R.id.titleView);
        titleView.setText(title);
        final TextView descriptionView = (TextView) view.findViewById(R.id.textDescription);
        descriptionView.setText(description);
    }
}
