package com.multipz.advohub.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.PentagonImageView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.multipz.advohub.Model.FeedBackModel;
import com.multipz.advohub.Model.HighcourtModel;
import com.multipz.advohub.R;

import java.util.List;

/**
 * Created by Admin on 01-12-2017.
 */

public class HighCourtAdapter extends RecyclerView.Adapter<HighCourtAdapter.MyViewHolder> {
    private List<HighcourtModel> expertsList;
    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView des, txt_time, txt_date;
        PorterShapeImageView imgview;


        public MyViewHolder(View view) {
            super(view);
            des = (TextView) view.findViewById(R.id.des);
            txt_time = (TextView) view.findViewById(R.id.txt_time);
            txt_date = (TextView) view.findViewById(R.id.txt_date);
            imgview = (PorterShapeImageView) view.findViewById(R.id.imgview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public HighCourtAdapter(List<HighcourtModel> expertsList) {
        this.expertsList = expertsList;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_high_court, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HighcourtModel model = expertsList.get(position);
        holder.des.setText(model.getText());
        holder.txt_time.setText(model.getTime());
        holder.txt_date.setText(model.getDate());
    }


    @Override
    public int getItemCount() {
        return expertsList.size();
    }
}
