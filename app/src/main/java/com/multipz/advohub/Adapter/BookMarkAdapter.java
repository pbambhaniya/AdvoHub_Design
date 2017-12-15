package com.multipz.advohub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.FeedBackModel;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;

import java.util.List;

/**
 * Created by Admin on 08-12-2017.
 */

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.MyViewHolder> {
    private List<SearchAdvocateModel> list;
    private BookMarkAdapter.ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_lawyer_name, txt_lawyer_type;
        ImageView img_lawyer, img_favourite;

        public MyViewHolder(View view) {
            super(view);
            txt_lawyer_name = (TextView) view.findViewById(R.id.txt_lawyer_name);
            txt_lawyer_type = (TextView) view.findViewById(R.id.txt_lawyer_type);
            img_lawyer = (ImageView) view.findViewById(R.id.img_lawyer);
            img_favourite = (ImageView) view.findViewById(R.id.img_favourite);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public BookMarkAdapter(Context context, List<SearchAdvocateModel> list) {
        this.list = list;
    }

    public void setClickListener(BookMarkAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public BookMarkAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lawyer_list, parent, false);

        return new BookMarkAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookMarkAdapter.MyViewHolder holder, int position) {
        SearchAdvocateModel model = list.get(position);
        holder.txt_lawyer_name.setText(model.getLawyer_name());
        holder.txt_lawyer_type.setText(model.getLawyer_type());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
