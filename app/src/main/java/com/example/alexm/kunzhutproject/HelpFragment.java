package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.label;

/**
 * Created by lubcik on 15.03.17.
 */

public class HelpFragment extends Fragment {
    private String title;
    private String decription;

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDecription(final String decription) {
        this.decription = decription;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView titleView = (TextView) view.findViewById(R.id.textTitle);
        titleView.setText(title);
        final TextView decriptionView = (TextView) view.findViewById(R.id.textDecription);
        decriptionView.setText(decription);
    }
}
