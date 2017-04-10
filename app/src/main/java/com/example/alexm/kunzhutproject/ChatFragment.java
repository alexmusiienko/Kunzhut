package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.chat_fragment, parent, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.my_recycler_view);
        final RecyclerViewAdapter recyclerViewAdapter;
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), getData());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final EditText editText = (EditText) layout.findViewById(R.id.chatText);
        Button button = (Button) layout.findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                text = editText.getText().toString().trim();
                if (text.isEmpty()) {
                    return;
                }
                InformationForRecyclerView informationForRecyclerView = new InformationForRecyclerView(MessageType.USER, text);
                recyclerViewAdapter.append(informationForRecyclerView);
                User.CURRENT.name = text;
                Step.nextStep();
                recyclerViewAdapter.append(new InformationForRecyclerView(MessageType.BOT, Step.getQuestion()));
                editText.setText("");
            }
        });
        return layout;
    }

    public static List<InformationForRecyclerView> getData() {
        List<InformationForRecyclerView> data = new ArrayList<>();
        data.add(new InformationForRecyclerView(MessageType.BOT, Step.getQuestion()));
        return data;

    }
}

