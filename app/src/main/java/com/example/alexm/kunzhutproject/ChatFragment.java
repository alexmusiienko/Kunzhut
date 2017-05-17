package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

        adapter = new ChatAdapter(recyclerView);

        recyclerView.setAdapter(adapter);

        adapter.setQuestions(questions);
    }
    
        static class QuestionViewHolder extends ViewHolder {

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

    private static class MultipleOptionsQuestionViewHolder extends QuestionViewHolder {

        private Button firstOptionButton;
        private Button secondOptionButton;
        private Button thirdOptionButton;

        public MultipleOptionsQuestionViewHolder(final View itemView) {
            super(itemView);

            firstOptionButton = (Button) itemView.findViewById(R.id.chat_select_button1);
            secondOptionButton = (Button) itemView.findViewById(R.id.chat_select_button2);
            thirdOptionButton = (Button) itemView.findViewById(R.id.chat_select_button3);
        }

        public void setFirstOptionButtonListener(final OnClickListener onClickListener) {
            firstOptionButton.setOnClickListener(onClickListener);
        }

        public void setSecondOptionButtonListener(final OnClickListener onClickListener) {
            secondOptionButton.setOnClickListener(onClickListener);
        }

        public void setThirdOptionButtonListener(final OnClickListener onClickListener) {
            thirdOptionButton.setOnClickListener(onClickListener);
        }
    }

    private class ChatAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

        private static final int BOOLEAN_QUESTION_VIEW = 100;
        private static final int MULTIPLE_OPTIONS_QUESTION_VIEW = 200;

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
        public int getItemViewType(final int position) {
            final Question question = displayedQuestions.get(position);

            if (question instanceof BooleanQuestion) {
                return BOOLEAN_QUESTION_VIEW;
            }

            return MULTIPLE_OPTIONS_QUESTION_VIEW;
        }

        @Override
        public QuestionViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            int layoutId;

            if (viewType == BOOLEAN_QUESTION_VIEW) {
                layoutId = R.layout.yes_no_bubbles;
            } else {
                layoutId = R.layout.select_mes_bot;
            }

            final View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

            if (viewType == BOOLEAN_QUESTION_VIEW) {
                return new BooleanQuestionViewHolder(view);
            } else {
                return new MultipleOptionsQuestionViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(final QuestionViewHolder holder, final int position) {
            final Question question = displayedQuestions.get(position);

            if (question instanceof BooleanQuestion) {
                setupBooleanHolder((BooleanQuestionViewHolder) holder, question);
            } else {
                setupMultipleOptionsHolder((MultipleOptionsQuestionViewHolder) holder, question);
            }
        }

        private void setupBooleanHolder(final BooleanQuestionViewHolder holder, final Question question) {
            final BooleanQuestion booleanQuestion = (BooleanQuestion) question;

            holder.setTitle(question.getQuestionTitle());
            holder.setPositiveListeners(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    booleanQuestion.setAnswer(true);
                    view.setEnabled(false);
                    view.setBackgroundResource(R.color.color_darken_button);
                    holder.negativeButton.setEnabled(false);
                    showNextQuestion();
                }
            });

            holder.setNegativeListeners(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    booleanQuestion.setAnswer(false);
                    view.setEnabled(false);
                    view.setBackgroundResource(R.color.color_darken_button);
                    holder.positiveButton.setEnabled(false);
                    showNextQuestion();
                }
            });
        }

        private void setupMultipleOptionsHolder(final MultipleOptionsQuestionViewHolder holder,
                                                final Question question) {
            final MultipleOptionQuestion multipleOptionQuestion = (MultipleOptionQuestion) question;

            holder.setTitle(question.getQuestionTitle());
            holder.firstOptionButton.setText(multipleOptionQuestion.getAnswerOptions().get(0));
            holder.secondOptionButton.setText(multipleOptionQuestion.getAnswerOptions().get(1));
            holder.thirdOptionButton.setText(multipleOptionQuestion.getAnswerOptions().get(2));

            holder.setFirstOptionButtonListener(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    multipleOptionQuestion.setAnswerIndex(0);
                    showNextQuestion();
                }
            });

            holder.setSecondOptionButtonListener(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    multipleOptionQuestion.setAnswerIndex(1);
                    showNextQuestion();
                }
            });

            holder.setThirdOptionButtonListener(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    multipleOptionQuestion.setAnswerIndex(2);
                    showNextQuestion();
                }
            });
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
