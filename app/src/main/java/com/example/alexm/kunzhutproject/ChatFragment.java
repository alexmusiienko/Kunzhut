package com.example.alexm.kunzhutproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.chat_fragment, parent, false);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), getData());
       //(!) recyclerView.setAdapter(recyclerViewAdapter);
        // (!) recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static List<InformationForRecyclerView> getData(){
        List<InformationForRecyclerView> data = new ArrayList<>();
        int [] icons = {R.layout.recycler_item_row};
       // for (int i = 0; i<1; i++) {
            InformationForRecyclerView current = new InformationForRecyclerView();
            current.iconId=icons[0];
            data.add(current);
        //}
        return data;

    }
}
