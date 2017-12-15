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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.multipz.advohub.Adapter.Adapter;
import com.multipz.advohub.Adapter.CaseListAdapter;
import com.multipz.advohub.Model.CaseListModel;
import com.multipz.advohub.Model.Model;
import com.multipz.advohub.R;
import com.multipz.advohub.activity.ChatAdvocateActivity;

import java.util.ArrayList;
import java.util.List;

public class CaseListActivity extends AppCompatActivity {
    RecyclerView rv_caselist;
    ImageView img_back;
    List<CaseListModel> list = new ArrayList<>();
    Context context;
    CaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_list);


        rv_caselist = (RecyclerView) findViewById(R.id.rv_caselist);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        CaseList();

    }

    private void CaseList() {
        adapter = new CaseListAdapter(list, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_caselist.setLayoutManager(mLayoutManager);
        rv_caselist.setItemAnimator(new DefaultItemAnimator());
        rv_caselist.setAdapter(adapter);
        rv_caselist.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        Data();

    }

    private void Data() {
        list.add(new CaseListModel("", "Lorem Ipsum Is simply dummy", "you posted on 10-08-2016"));
        list.add(new CaseListModel("", "Lorem Ipsum Is simply dummy", "you posted on 10-08-2016"));
        list.add(new CaseListModel("", "Lorem Ipsum Is simply dummy", "you posted on 10-08-2016"));
        list.add(new CaseListModel("", "Lorem Ipsum Is simply dummy", "you posted on 10-08-2016"));
        list.add(new CaseListModel("", "Lorem Ipsum Is simply dummy", "you posted on 10-08-2016"));
        adapter.notifyDataSetChanged();
    }


    class itemInClickListener implements CaseListAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {

            Intent intent = new Intent(CaseListActivity.this, PostCasesActivity.class);
            startActivity(intent);
        }
    }
}
