package com.multipz.advohub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.multipz.advohub.Adapter.DictionarySearchAdapter;
import com.multipz.advohub.Adapter.SearchAdvocateAdapter;
import com.multipz.advohub.Model.DictionarySearchModel;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;
import com.multipz.advohub.User.SearchAdvocateActivity;
import com.multipz.advohub.User.SearchAdvocateDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class DictionaryActivity extends AppCompatActivity {
    ImageView img_search, img_back;
    RelativeLayout rel_search;
    RecyclerView rv_serach;
    Context context;
    EditText edit_search_item;
    DictionarySearchAdapter adapter;
    private List<DictionarySearchModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        context = this;
        img_back = (ImageView) findViewById(R.id.img_back);
        img_search = (ImageView) findViewById(R.id.img_search);
        edit_search_item = (EditText) findViewById(R.id.edit_search_item);
        rv_serach = (RecyclerView) findViewById(R.id.rv_serach);
        rel_search = (RelativeLayout) findViewById(R.id.rel_search);


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel_search.setVisibility(View.VISIBLE);
            }
        });

        edit_search_item.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence constraint, int i, int i1, int i2) {
                adapter.filter(constraint.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        LawyerList();

    }

    private void LawyerList() {
        adapter = new DictionarySearchAdapter(list, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_serach.setLayoutManager(mLayoutManager);
        rv_serach.setItemAnimator(new DefaultItemAnimator());
        rv_serach.setAdapter(adapter);
        rv_serach.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        Data();
    }

    private void Data() {
        list.add(new DictionarySearchModel("Raju"));
        list.add(new DictionarySearchModel("vk"));
        list.add(new DictionarySearchModel("dk"));
        list.add(new DictionarySearchModel("all"));
        list.add(new DictionarySearchModel("ket"));
        list.add(new DictionarySearchModel("rat"));
        list.add(new DictionarySearchModel("dhaval"));
        list.add(new DictionarySearchModel("vapi"));
        list.add(new DictionarySearchModel("surat"));
        list.add(new DictionarySearchModel("paresh"));
        list.add(new DictionarySearchModel("dhaval" ));
        list.add(new DictionarySearchModel("rajesh"));
        list.add(new DictionarySearchModel("dk"));
        list.add(new DictionarySearchModel("vk"));
        list.add(new DictionarySearchModel("kartik"));
        list.add(new DictionarySearchModel("jk"));
        list.add(new DictionarySearchModel("nk"));
        adapter.notifyDataSetChanged();
        adapter.filter("");
    }


    class itemInClickListener implements DictionarySearchAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            DictionarySearchModel model = list.get(position);
            Intent intent = new Intent(DictionaryActivity.this, DictionaryDetailActivity.class);
            intent.putExtra("Name", model.getName());
            startActivity(intent);
        }
    }
}
