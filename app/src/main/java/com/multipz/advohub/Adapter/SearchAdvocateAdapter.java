package com.multipz.advohub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.HighcourtModel;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08-12-2017.
 */

public class SearchAdvocateAdapter extends RecyclerView.Adapter<SearchAdvocateAdapter.MyViewHolder> {
    private List<SearchAdvocateModel> expertsListMain;
    private List<SearchAdvocateModel> expertsList;
    private SearchAdvocateAdapter.ClickListener clickListener;

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


    public SearchAdvocateAdapter(List<SearchAdvocateModel> expertsList, Context context) {

        this.expertsList = new ArrayList<>();
        this.expertsListMain = expertsList;
        this.expertsList.addAll(expertsListMain);
    }

    public void setClickListener(SearchAdvocateAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public SearchAdvocateAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lawyer_list, parent, false);
        return new SearchAdvocateAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchAdvocateAdapter.MyViewHolder holder, int position) {
        SearchAdvocateModel model = expertsList.get(position);
        holder.txt_lawyer_name.setText(model.getLawyer_name());
        holder.txt_lawyer_type.setText(model.getLawyer_type());
    }

    public void filter(String text) {
        //new array list that will hold the filtered data
        expertsList.clear();

        //looping through existing elements
        for (SearchAdvocateModel s : expertsListMain) {
            if (s.getLawyer_name().toLowerCase().contains(text.toLowerCase())) {
                expertsList.add(s);
            }
        }
      /*  if (text.length() <= 0) {
            expertsList.addAll(expertsListMain);
        }
*/
        //calling a method of the adapter class and passing the filtered list
        filterList(expertsList);
    }

    public void filterList(List<SearchAdvocateModel> filterdNames) {
        this.expertsList = filterdNames;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return expertsList.size();
    }
}
