package com.multipz.advohub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.Model.DictionarySearchModel;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11-12-2017.
 */

public class DictionarySearchAdapter extends RecyclerView.Adapter<DictionarySearchAdapter.MyViewHolder> {
    private List<DictionarySearchModel> expertsListMain;
    private List<DictionarySearchModel> expertsList;
    private DictionarySearchAdapter.ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_word;


        public MyViewHolder(View view) {
            super(view);
            txt_word = (TextView) view.findViewById(R.id.txt_word);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public DictionarySearchAdapter(List<DictionarySearchModel> expertsList, Context context) {

        this.expertsList = new ArrayList<>();
        this.expertsListMain = expertsList;
        this.expertsList.addAll(expertsListMain);
    }

    public void setClickListener(DictionarySearchAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public DictionarySearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dictionary, parent, false);
        return new DictionarySearchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DictionarySearchAdapter.MyViewHolder holder, int position) {
        DictionarySearchModel model = expertsList.get(position);
        holder.txt_word.setText(model.getName());
    }

    public void filter(String text) {
        //new array list that will hold the filtered data
        expertsList.clear();

        //looping through existing elements
        for (DictionarySearchModel s : expertsListMain) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                expertsList.add(s);
            }
        }
//        if (text.length() <= 0) {
//            expertsList.addAll(expertsListMain);
//        }

        //calling a method of the adapter class and passing the filtered list
        filterList(expertsList);
    }

    public void filterList(List<DictionarySearchModel> filterdNames) {
        this.expertsList = filterdNames;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return expertsList.size();
    }
}
