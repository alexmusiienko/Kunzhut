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
import android.widget.RelativeLayout;

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
                text = editText.getText().toString();
                InformationForRecyclerView informationForRecyclerView = new InformationForRecyclerView();
                informationForRecyclerView.title = text;
                informationForRecyclerView.iconId = R.mipmap.bot_face;
                recyclerViewAdapter.data.add(informationForRecyclerView);
                recyclerViewAdapter.notifyDataSetChanged();

            }
        });
        return layout;
    }

    public static List<InformationForRecyclerView> getData() {
        List<InformationForRecyclerView> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            InformationForRecyclerView current = new InformationForRecyclerView();
            current.iconId = R.mipmap.bot_face;
            current.title = "text" + String.valueOf(i);
            data.add(current);
        }
        return data;

    }
}

