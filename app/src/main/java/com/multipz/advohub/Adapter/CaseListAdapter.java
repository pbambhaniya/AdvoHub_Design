package com.multipz.advohub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.CaseListModel;
import com.multipz.advohub.Model.FeedBackModel;
import com.multipz.advohub.R;

import java.util.List;

/**
 * Created by Admin on 11-12-2017.
 */

public class CaseListAdapter extends RecyclerView.Adapter<CaseListAdapter.MyViewHolder> {
    private List<CaseListModel> list;
    private CaseListAdapter.ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_des, txt_date;


        public MyViewHolder(View view) {
            super(view);
            txt_des = (TextView) view.findViewById(R.id.txt_des);
            txt_date = (TextView) view.findViewById(R.id.txt_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public CaseListAdapter(List<CaseListModel> expertsList, Context context) {
        this.list = expertsList;
    }

    public void setClickListener(CaseListAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public CaseListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_case_list, parent, false);
        return new CaseListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CaseListAdapter.MyViewHolder holder, int position) {
        CaseListModel model = list.get(position);
        holder.txt_des.setText(model.getDes());
        holder.txt_date.setText(model.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
