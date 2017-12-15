package com.multipz.advohub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.CaseListModel;
import com.multipz.advohub.Model.PostCaseModel;
import com.multipz.advohub.R;

import java.util.List;

/**
 * Created by Admin on 11-12-2017.
 */

public class PostCaseAdapter extends RecyclerView.Adapter<PostCaseAdapter.MyViewHolder> {
    private List<PostCaseModel> list;
    private PostCaseAdapter.ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_lawyername;
        ImageView img;


        public MyViewHolder(View view) {
            super(view);
            txt_lawyername = (TextView) view.findViewById(R.id.txt_lawyername);
            img = (ImageView) view.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public PostCaseAdapter(List<PostCaseModel> list, Context context) {
        this.list = list;
    }

    public void setClickListener(PostCaseAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public PostCaseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post_case, parent, false);
        return new PostCaseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostCaseAdapter.MyViewHolder holder, int position) {
        PostCaseModel model = list.get(position);
        holder.txt_lawyername.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
