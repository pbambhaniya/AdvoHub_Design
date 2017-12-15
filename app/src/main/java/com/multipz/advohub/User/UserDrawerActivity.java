package com.multipz.advohub.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.multipz.advohub.R;
import com.multipz.advohub.activity.SignInUpActivity;
import com.multipz.advohub.fragment.UserDeshboardFragment;

public class UserDrawerActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{
    FragmentTransaction transaction;
    LinearLayout lnr_home, lnr_log_out;
    TextView txt_name;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.menu_open);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });


        lnr_home = (LinearLayout) findViewById(R.id.lnr_home);
        lnr_log_out = (LinearLayout) findViewById(R.id.lnr_logout);
        txt_name = (TextView) findViewById(R.id.txt_name);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        setToolbarName("ADVOHUB");
        drawer.closeDrawer(GravityCompat.START);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containers, new UserDeshboardFragment()).commit();


        lnr_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToolbarName("ADVOHUB");
                drawer.closeDrawer(GravityCompat.START);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containers, new UserDeshboardFragment()).commit();
            }
        });

        lnr_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDrawerActivity.this, SignInUpActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setToolbarName(String name) {
        txt_name.setText(name);
    }
}
