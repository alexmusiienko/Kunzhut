package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

    private static class ReportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private RecyclerView recyclerView;
        private List<Question> questions;

        private ReportAdapter(final RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        public void setQuestions(final List<Question> questions) {
            this.questions = questions;
            this.questions = new ArrayList<>();

            questions.add(questions.remove(0));

            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

           /*
            recyclerViewReport = (RecyclerView) getView().findViewById(R.id.recyclerView);
            recyclerViewReport.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewReport.setAdapter((RecyclerView.Adapter) ReportAdapter)
            ReportAdapter.setQuestions(questions);

            final Question question = displayedQuestions.get(position);
           */
        }

        @Override
        public int getItemCount() {
            return questions.size();
        }
    }
}


