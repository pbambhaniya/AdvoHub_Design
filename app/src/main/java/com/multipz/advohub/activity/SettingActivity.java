package com.multipz.advohub.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;

import com.multipz.advohub.R;


public class SettingActivity extends AppCompatActivity {
    ImageView img_down, img_up, img_up_notification, img_down_notification;
    LinearLayout lnr_detail, notification_detail;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        img_down = (ImageView) findViewById(R.id.img_down);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_up = (ImageView) findViewById(R.id.img_up);
        lnr_detail = (LinearLayout) findViewById(R.id.lnr_detail);
        img_up_notification = (ImageView) findViewById(R.id.img_up_notification);
        notification_detail = (LinearLayout) findViewById(R.id.notification_detail);
        img_down_notification = (ImageView) findViewById(R.id.img_down_notification);


        img_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_up.setVisibility(View.VISIBLE);
                img_down.setVisibility(View.GONE);
                lnr_detail.setVisibility(View.VISIBLE);
            }
        });

        img_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_down.setVisibility(View.VISIBLE);
                img_up.setVisibility(View.GONE);
                lnr_detail.setVisibility(View.GONE);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        img_down_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_up_notification.setVisibility(View.VISIBLE);
                notification_detail.setVisibility(View.VISIBLE);
                img_down_notification.setVisibility(View.GONE);
            }
        });

        img_up_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_up_notification.setVisibility(View.GONE);
                img_down_notification.setVisibility(View.VISIBLE);
                notification_detail.setVisibility(View.GONE);
            }
        });

        

    }
}
