package com.multipz.advohub.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.multipz.advohub.R;
import com.multipz.advohub.User.UserDrawerActivity;
import com.multipz.advohub.util.Toaster;

/**
 * Created by Admin on 30-11-2017.
 */

public class SignInUpActivity extends AppCompatActivity {

    Context context;
    TextView btn_user, btn_done, txt_lawyer, txt_user;
    private ImageView img_back;
    EditText et_password, et_user_name;
    private String SelectUser;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinup);

        context = this;
        initTab();

    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initTab() {


        final LinearLayout lnrSignup = (LinearLayout) findViewById(R.id.lnr_signup);
        final LinearLayout lnrLogin = (LinearLayout) findViewById(R.id.lnr_login);
        LinearLayout lnrSignupTab = (LinearLayout) findViewById(R.id.lnr_signup_tab);
        LinearLayout lnrLoginTab = (LinearLayout) findViewById(R.id.lnr_login_tab);
        final TextView txtSignup = (TextView) findViewById(R.id.txt_signup_tab);
        final TextView txtLogin = (TextView) findViewById(R.id.txt_login_tab);
        final ImageView imgSignup = (ImageView) findViewById(R.id.img_signup_tab);
        final ImageView imgLogin = (ImageView) findViewById(R.id.img_login_tab);
        txt_lawyer = (TextView) findViewById(R.id.txt_lawyer);
        txt_user = (TextView) findViewById(R.id.txt_user);

        img_back = (ImageView) findViewById(R.id.img_back);
        btn_user = (TextView) findViewById(R.id.btn_user);
        btn_done = (TextView) findViewById(R.id.btn_done);

        et_password = (EditText) findViewById(R.id.et_password);
        et_user_name = (EditText) findViewById(R.id.et_user_name);


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SelectUser = getIntent().getStringExtra("SelectUser");
        if (SelectUser != null) {
            if (SelectUser.contentEquals("Lawyer")) {
                txt_lawyer.setBackgroundResource(R.drawable.bg_btn_app);
                txt_lawyer.setTextColor(Color.parseColor("#ffffff"));
                txt_user.setBackgroundResource(R.drawable.bg_btn_null_app_border);
                txt_user.setTextColor(Color.parseColor("#000000"));
            } else if (SelectUser.contentEquals("User")) {
                txt_user.setBackgroundResource(R.drawable.bg_btn_app);
                txt_user.setTextColor(Color.parseColor("#ffffff"));
                txt_lawyer.setBackgroundResource(R.drawable.bg_btn_null_app_border);
                txt_lawyer.setTextColor(Color.parseColor("#000000"));
            }

        } else {
            Toaster.getToast(getApplicationContext(), "Please select User");
        }


        lnrLoginTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lnrLogin.setVisibility(View.VISIBLE);
                txtLogin.setTextColor(getResources().getColor(R.color.colorPrimary));
                txtLogin.setBackgroundColor(getResources().getColor(R.color.colorBgPage));
                imgLogin.setVisibility(View.VISIBLE);

                lnrSignup.setVisibility(View.GONE);
                lnrLogin.setVisibility(View.VISIBLE);

                imgSignup.setVisibility(View.INVISIBLE);
                txtSignup.setTextColor(getResources().getColor(R.color.colorWhite));
                txtSignup.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        lnrSignupTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSignup.setTextColor(getResources().getColor(R.color.colorPrimary));
                txtSignup.setBackgroundColor(getResources().getColor(R.color.colorBgPage));
                imgSignup.setVisibility(View.VISIBLE);

                lnrSignup.setVisibility(View.VISIBLE);
                lnrLogin.setVisibility(View.GONE);

                imgLogin.setVisibility(View.INVISIBLE);
                txtLogin.setTextColor(getResources().getColor(R.color.colorWhite));
                txtLogin.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });


        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_user_name.getText().toString().contentEquals("Paresh") && et_password.getText().toString().contentEquals("123")) {
                    Intent intent = new Intent(SignInUpActivity.this, ActivityMenu.class);
                    startActivity(intent);
                } else if (et_user_name.getText().toString().contentEquals("Dhaval") && et_password.getText().toString().contentEquals("123")) {
                    Intent intent = new Intent(SignInUpActivity.this, UserDrawerActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "Please Enter UserName and Password", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInUpActivity.this, AddDetailActivity.class);
                startActivity(intent);

            }
        });


    }
}
