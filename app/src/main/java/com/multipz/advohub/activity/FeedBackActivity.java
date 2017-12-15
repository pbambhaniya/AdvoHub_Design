package com.multipz.advohub.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.multipz.advohub.Adapter.Adapter;
import com.multipz.advohub.Adapter.FeedBackAdapter;
import com.multipz.advohub.Model.FeedBackModel;
import com.multipz.advohub.Model.Model;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

public class FeedBackActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    FeedBackAdapter adapter;
    Context context;
    private List<FeedBackModel> list = new ArrayList<>();
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        context = this;
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Feedback();
    }

    private void Feedback() {
        adapter = new FeedBackAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
        recyclerview.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());

        prepareExpertIn();
    }


    class itemInClickListener implements FeedBackAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();

            FeedBackModel model = list.get(position);

            popUpAlert();
        }
    }

    private void prepareExpertIn() {
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        list.add(new FeedBackModel("Ketan", "GoodWork"));
        adapter.notifyDataSetChanged();
    }


    public void popUpAlert() {
        LayoutInflater inflater = FeedBackActivity.this.getLayoutInflater();
        View c = inflater.inflate(R.layout.popup_feedback, null);

//        LinearLayout okay = (LinearLayout) c.findViewById(R.id.okay);
        AlertDialog.Builder builder = new AlertDialog.Builder(FeedBackActivity.this);
        builder.setView(c);

        final AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

//        okay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//    }
    }

}
