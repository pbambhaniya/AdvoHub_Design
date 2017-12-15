package com.multipz.advohub.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.multipz.advohub.R;
import com.multipz.advohub.util.Toaster;

/**
 * Created by Admin on 30-11-2017.
 */

public class SelectUserActivity extends AppCompatActivity {

    Context context;
    private TextView txt_select_lawyer, txt_select_user;
    private String SelectUser = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        context = this;

        reference();
        init();
    }

    private void reference() {
        txt_select_lawyer = (TextView) findViewById(R.id.txt_select_lawyer);
        txt_select_user = (TextView) findViewById(R.id.txt_select_user);

    }

    private void init() {
       /* findViewById(R.id.txt_lawyer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, SignInUpActivity.class));
            }
        });
        findViewById(R.id.txt_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


        findViewById(R.id.lnr_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!SelectUser.contentEquals("")) {
                    if (SelectUser.contentEquals("Lawyer")) {
                        Intent i = new Intent(context, SignInUpActivity.class);
                        i.putExtra("SelectUser", SelectUser);
                        startActivity(i);
                    } else if (SelectUser.contentEquals("User")) {
                        Intent i = new Intent(context, SignInUpActivity.class);
                        i.putExtra("SelectUser", SelectUser);
                        startActivity(i);
                    }
                } else {
                    Toaster.getToast(getApplicationContext(), "Please Select User");
                }
            }
        });

        txt_select_lawyer.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (txt_select_lawyer.getText().toString().contentEquals("Lawyer")) {
                    txt_select_lawyer.setBackgroundResource(R.drawable.bg_btn_app);
                    txt_select_lawyer.setTextColor(Color.parseColor("#FFFFFF"));
                    txt_select_user.setBackgroundResource(R.drawable.bg_btn_null_app_border);
                    txt_select_user.setTextColor(Color.parseColor("#000000"));
                }
                // startActivity(new Intent(context, SignInUpActivity.class));

                SelectUser = "Lawyer";
                txt_select_lawyer.setText(SelectUser);
            }
        });

        txt_select_user.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (txt_select_user.getText().toString().contentEquals("User")) {
                    txt_select_user.setBackgroundResource(R.drawable.bg_btn_app);
                    txt_select_user.setTextColor(Color.parseColor("#FFFFFF"));
                    txt_select_lawyer.setBackgroundResource(R.drawable.bg_btn_null_app_border);
                    txt_select_lawyer.setTextColor(Color.parseColor("#000000"));
                }
                SelectUser = "User";
                txt_select_user.setText(SelectUser);
            }
        });


    }
}
