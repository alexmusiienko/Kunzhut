package com.example.alexm.kunzhutproject;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private LayoutInflater inflater;
    List<InformationForRecyclerView> data = Collections.emptyList();

    public RecyclerViewAdapter (Context context, List<InformationForRecyclerView> data){
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.chat_fragment, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InformationForRecyclerView current = data.get(position);
        //holder.textView.setText(current.title);

        holder.imageView.setImageResource(current.iconId);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
       // textView = (TextView) itemView.findViewById(R.id.botHelloText);
            imageView = (ImageView) itemView.findViewById(R.id.botFace);
            ///linearLayout = (LinearLayout) itemView.findViewById(R.id.botBackground);

        }

    }
}