package com.example.alexm.kunzhutproject;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<InformationForRecyclerView> data = Collections.emptyList();

    public RecyclerViewAdapter(Context context, List<InformationForRecyclerView> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void append(InformationForRecyclerView element) {
        data.add(element);
        notifyDataSetChanged();
        System.out.println("---------- ITEM WAS ADDED");
        System.out.println(data.size());
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type.ordinal();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final int id = viewType == MessageType.BOT.ordinal() ? R.layout.mes_bot : R.layout.mes_user;
        View view = inflater.inflate(id, parent, false);
        return new MyViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InformationForRecyclerView current = data.get(position);
        holder.textView.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView, int type) {
            super(itemView);
            int id = type == MessageType.BOT.ordinal() ? R.id.bot_text_view : R.id.user_text_view;
            textView = (TextView) itemView.findViewById(id);
        }
    }
}