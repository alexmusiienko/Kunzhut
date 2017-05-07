package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lubcik on 03.05.17.
 */

public class  ReportFragment extends Fragment {
    private List<Question> displayedQuestions;
    private RecyclerView recyclerView2;
    private List<Question> questions;

     public void setQuestions(final List<Question> questions) {
        this.questions = questions;
    }

    public void setListOfAnwer(List<Question> displayedQuestions) {
        this.displayedQuestions = displayedQuestions;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_fragment, container, false);

    }
   /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView2 = (RecyclerView) getView().findViewById(R.id.recyclerView1);
        recyclerView2.setQuestions(questions);
        recyclerView2.setListOfAnswer(displayedQuestions);
    }*/
}

