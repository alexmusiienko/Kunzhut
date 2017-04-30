package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class ChatFragment extends Fragment {

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

        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ChatAdapter(recyclerView);

        recyclerView.setAdapter(adapter);

        adapter.setQuestions(questions);
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
