package com.multipz.advohub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.multipz.advohub.Adapter.NotificationAdapter;
import com.multipz.advohub.Model.NotificationModel;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView rv_notification;
    ImageView img_back;
    Context context;
    private List<NotificationModel> list = new ArrayList<>();
    public NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        context = this;
        rv_notification = (RecyclerView) findViewById(R.id.rv_notification);
        img_back = (ImageView) findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Notification();
    }

    private void Notification() {
        adapter = new NotificationAdapter(context, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_notification.setLayoutManager(mLayoutManager);
        rv_notification.setItemAnimator(new DefaultItemAnimator());
        rv_notification.setAdapter(adapter);
        rv_notification.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());

        DummyData();
    }


    public class itemInClickListener implements NotificationAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {

            Intent intent = new Intent(NotificationActivity.this, NotificationAcceptActivity.class);
            startActivity(intent);
        }
    }

    private void DummyData() {
        list.add(new NotificationModel("paresh", "2 Hours Ago", ""));
        list.add(new NotificationModel("paresh", "2 Hours Ago", ""));
        list.add(new NotificationModel("paresh", "2 Hours Ago", ""));
        list.add(new NotificationModel("paresh", "2 Hours Ago", ""));
        adapter.notifyDataSetChanged();
    }
}
