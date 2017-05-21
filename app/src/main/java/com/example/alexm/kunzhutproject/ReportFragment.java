package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReportFragment extends GeneralFragment {
    private TextView titleOfAnswer;
    private List<Question> answers;

    public void setAnswers(final List<Question> questions) {
        this.answers = answers;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showBackButton();

        ArrayList<String> steps = new ArrayList();

        steps.add("«Импортонезависимую технологическую платформу для разработки распределенных информационно-вычислительных систем на основе свободного" +
                " программного обеспечения» разработали ученые лаборатории информационных " +
                "технологий Всероссийского НИИ овцеводства");
        steps.add("«На сегодняшний день существуют российские программные " +
                "продукты, но почти все они работают под управлением операционной системы Windows," +
                " либо используют программные библиотеки и компоненты иностранных " +
                "компаний, а значит в любом случае импортозависимы");
        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ReportAdapter adapter = new ReportAdapter();
        adapter.setSteps(steps);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void showBackButton() {
        super.showBackButton();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToMenu();
            }
        });
    }

    private void goBackToMenu() {
        MainActivity activity = (MainActivity) getActivity();
        activity.goBackToMenu();
    }

    private class ReportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int VIEW_STEP = 0;
        private static final int VIEW_START_OVER = 1;

        private List<String> steps;

        public void setSteps(List<String> steps) {
            this.steps = steps;
            notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            return position == steps.size() ? VIEW_START_OVER : VIEW_STEP;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layoutId = viewType == VIEW_STEP ? R.layout.steps_layout : R.layout.start_over_layout;

            final View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

            return viewType == VIEW_STEP ? new StepViewHolder(view) : new StartOverHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            if (position == steps.size()) {
                setupStartOverHolder((StartOverHolder) viewHolder);
            } else {
                setupStepHolder((StepViewHolder) viewHolder, position);
            }
        }

        private void setupStartOverHolder(StartOverHolder viewHolder) {
            StartOverHolder holder = viewHolder;
            holder.startOverButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBackToMenu();
                }
            });
        }

        private void setupStepHolder(StepViewHolder viewHolder, int position) {
            StepViewHolder holder = viewHolder;

            String title = "Крок " + (position + 1);

            final String stepText = steps.get(position);
            holder.stepView.setText(steps.get(position));
            holder.stepTitleView.setText(title);
        }

        @Override
        public int getItemCount() {
            return steps.size() + 1;
        }
    }

    private static class StepViewHolder extends RecyclerView.ViewHolder {

        private TextView stepTitleView;
        private TextView stepView;

        public StepViewHolder(final View itemView) {
            super(itemView);
            stepTitleView = (TextView) itemView.findViewById(R.id.step_title);
            stepView = (TextView) itemView.findViewById(R.id.stepView);
        }

    }

    private static class StartOverHolder extends RecyclerView.ViewHolder {

        private Button startOverButton;

        public StartOverHolder(View itemView) {
            super(itemView);

            startOverButton = (Button) itemView.findViewById(R.id.start_over_button);
        }
    }
}