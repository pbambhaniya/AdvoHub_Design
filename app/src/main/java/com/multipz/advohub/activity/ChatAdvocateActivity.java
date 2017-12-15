package com.multipz.advohub.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.multipz.advohub.Adapter.Adapter;
import com.multipz.advohub.Model.Model;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

public class ChatAdvocateActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    Adapter adapter;
    Context context;
    private List<Model> list = new ArrayList<>();
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_advocate);
        context = this;
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        img_back = (ImageView) findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Chat();
    }


    private void Chat() {
        adapter = new Adapter(list, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
        recyclerview.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        Data();
    }

    private void Data() {
        list.add(new Model("", "Doctore"));
        list.add(new Model("", "Nurse"));
        list.add(new Model("", "Ditesion"));
        list.add(new Model("", "Doctore"));
        list.add(new Model("", "Nurse"));
        list.add(new Model("", "Ditesion"));
        list.add(new Model("", "Doctore"));
        list.add(new Model("", "Nurse"));
        list.add(new Model("", "Ditesion"));
        list.add(new Model("", "Doctore"));
        list.add(new Model("", "Nurse"));
        list.add(new Model("", "Ditesion"));
        adapter.notifyDataSetChanged();
    }

    class itemInClickListener implements Adapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
        }
    }
}
