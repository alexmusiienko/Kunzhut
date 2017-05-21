package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends GeneralFragment {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;

    private List<Question> questions;

    public void setQuestions(final List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat_fragment, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showBackButton();

        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (questions != null && questions.size() > 0) {
            adapter = new ChatAdapter(recyclerView);

            recyclerView.setAdapter(adapter);

            adapter.setQuestions(questions);
        }
    }

    private static class QuestionViewHolder extends ViewHolder {

        private TextView title;

        public QuestionViewHolder(final View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.question_title);
        }

        public void setTitle(final String titleText) {
            title.setText(titleText);
        }
    }

    private static class BooleanQuestionViewHolder extends QuestionViewHolder {

        private Button positiveButton;
        private Button negativeButton;

        public BooleanQuestionViewHolder(final View itemView) {
            super(itemView);

            positiveButton = (Button) itemView.findViewById(R.id.chat_select_button1);
            negativeButton = (Button) itemView.findViewById(R.id.chat_select_button2);
        }

        public void setPositiveListeners(final OnClickListener onClickListener) {
            positiveButton.setOnClickListener(onClickListener);
        }

        public void setNegativeListeners(final OnClickListener onClickListener) {
            negativeButton.setOnClickListener(onClickListener);
        }
    }

    private class ChatAdapter extends RecyclerView.Adapter<BooleanQuestionViewHolder> {

        private RecyclerView recyclerView;

        private List<Question> questions;
        private List<Question> displayedQuestions;

        private ChatAdapter(final RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        public void setQuestions(final List<Question> questions) {
            this.questions = questions;
            this.displayedQuestions = new ArrayList<>();

            displayedQuestions.add(questions.remove(0));

            notifyDataSetChanged();
        }

        @Override
        public BooleanQuestionViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            final View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.yes_no_bubbles, parent, false);

            return new BooleanQuestionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final BooleanQuestionViewHolder holder, final int position) {
            final Question question = displayedQuestions.get(position);

            setupBooleanHolder((BooleanQuestionViewHolder) holder, (BooleanQuestion) question);
        }

        private void setupBooleanHolder(final BooleanQuestionViewHolder holder,
                                        final BooleanQuestion question) {
            holder.setTitle(question.getQuestionTitle());

            if (question.isAnswered()) {
                setupAnsweredQuestionHolder(holder, question);
            } else {
                setupUnansweredQuestionHolder(holder, question);
            }
        }

        private void setupUnansweredQuestionHolder(final BooleanQuestionViewHolder holder,
                                                   final BooleanQuestion question) {
            holder.positiveButton.setEnabled(true);
            holder.negativeButton.setEnabled(true);
            holder.positiveButton.setBackgroundResource(R.color.color_default_button);
            holder.negativeButton.setBackgroundResource(R.color.color_default_button);

            holder.setPositiveListeners(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    question.setAnswered(true);
                    question.setAnswer(true);
                    view.setEnabled(false);
                    view.setBackgroundResource(R.color.color_darken_button);
                    holder.negativeButton.setEnabled(false);
                    showNextQuestion();
                }
            });

            holder.setNegativeListeners(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    question.setAnswered(true);
                    question.setAnswer(false);
                    view.setEnabled(false);
                    view.setBackgroundResource(R.color.color_darken_button);
                    holder.positiveButton.setEnabled(false);
                    showNextQuestion();
                }
            });
        }

        private void setupAnsweredQuestionHolder(final BooleanQuestionViewHolder holder,
                                                 final BooleanQuestion question) {
            holder.positiveButton.setEnabled(false);
            holder.negativeButton.setEnabled(false);

            if (question.isAnswerPositive()) {
                holder.positiveButton.setBackgroundResource(R.color.color_darken_button);
                holder.negativeButton.setBackgroundResource(R.color.color_default_button);
            } else {
                holder.positiveButton.setBackgroundResource(R.color.color_default_button);
                holder.negativeButton.setBackgroundResource(R.color.color_darken_button);
            }
        }

        private void showNextQuestion() {
            if (questions.size() >= 1) {
                displayedQuestions.add(questions.remove(0));
                notifyDataSetChanged();

                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.smoothScrollToPosition(displayedQuestions.size() - 1);
                    }
                });
            } else {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new ReportFragment(), true);

            }
        }

        @Override
        public int getItemCount() {
            return displayedQuestions.size();
        }
    }
}
