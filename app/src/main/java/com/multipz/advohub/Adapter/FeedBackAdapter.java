package com.multipz.advohub.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.FeedBackModel;
import com.multipz.advohub.R;

import java.util.List;

/**
 * Created by Admin on 01-12-2017.
 */

public class FeedBackAdapter extends RecyclerView.Adapter<FeedBackAdapter.MyViewHolder> {
    private List<FeedBackModel> expertsList;
    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_client_name, txt_work;


        public MyViewHolder(View view) {
            super(view);
            txt_client_name = (TextView) view.findViewById(R.id.txt_client_name);
            txt_work = (TextView) view.findViewById(R.id.txt_work);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public FeedBackAdapter(List<FeedBackModel> expertsList) {
        this.expertsList = expertsList;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feedback, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeedBackModel feedBackModel = expertsList.get(position);
        holder.txt_client_name.setText(feedBackModel.getClientname());
        holder.txt_work.setText(feedBackModel.getWork());

    }

    @Override
    public int getItemCount() {
        return expertsList.size();
    }
}
