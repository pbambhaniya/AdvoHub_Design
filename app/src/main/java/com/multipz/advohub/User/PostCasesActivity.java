package com.multipz.advohub.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.multipz.advohub.Adapter.CaseListAdapter;
import com.multipz.advohub.Adapter.PostCaseAdapter;
import com.multipz.advohub.Model.CaseListModel;
import com.multipz.advohub.Model.PostCaseModel;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

public class PostCasesActivity extends AppCompatActivity {
    ImageView img_back;
    RecyclerView recyclerview;
    PostCaseAdapter adapter;
    List<PostCaseModel> list = new ArrayList<>();
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_cases);
        img_back = (ImageView) findViewById(R.id.img_back);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Poscase();
    }

    private void Poscase() {
        adapter = new PostCaseAdapter(list, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
        recyclerview.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        Data();
    }

    private void Data() {
        list.add(new PostCaseModel("", "DhavalBhai"));
        list.add(new PostCaseModel("", "AshishBhai"));
        list.add(new PostCaseModel("", "RajuBhai"));
        list.add(new PostCaseModel("", "Kalubhai"));
        list.add(new PostCaseModel("", "Kalubhai"));
        adapter.notifyDataSetChanged();
    }

    class itemInClickListener implements PostCaseAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {


            Intent intent = new Intent(PostCasesActivity.this, AsignCaseLawyerActivity.class);
            startActivity(intent);
        }
    }


}
