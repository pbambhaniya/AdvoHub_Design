package com.multipz.advohub.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.multipz.advohub.R;
import com.multipz.advohub.fragment.DeshboardFragment;
import com.multipz.advohub.fragment.MyProfileFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityMenu extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{
    FragmentTransaction transaction;
    ImageView img_menu;
    TextView txt_name;
    ImageView img_setting;
    RelativeLayout img_notification;
    LinearLayout lnr_home, lnr_my_profile, lnr_privacy_policy, lnr_terms_condition, lnr_faq, lnr_support, lnr_logout;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_setting = (ImageView) findViewById(R.id.img_setting);
        img_notification = (RelativeLayout) findViewById(R.id.img_notification);
        txt_name = (TextView) findViewById(R.id.txt_name);
        lnr_home = (LinearLayout) findViewById(R.id.lnr_home);
        lnr_my_profile = (LinearLayout) findViewById(R.id.lnr_my_profile);
        lnr_privacy_policy = (LinearLayout) findViewById(R.id.lnr_privacy_policy);
        lnr_terms_condition = (LinearLayout) findViewById(R.id.lnr_my_profile);
        lnr_faq = (LinearLayout) findViewById(R.id.lnr_terms_condition);
        lnr_support = (LinearLayout) findViewById(R.id.lnr_faq);
        lnr_logout = (LinearLayout) findViewById(R.id.lnr_logout);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        img_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMenu.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        lnr_my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToolbarName("My Profile");
                drawer.closeDrawer(GravityCompat.START);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new MyProfileFragment()).commit();
            }
        });
        lnr_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToolbarName("ADHOHUB");
                drawer.closeDrawer(GravityCompat.START);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new DeshboardFragment()).commit();
            }
        });

        lnr_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ActivityMenu.this, SignInUpActivity.class);
                startActivity(intent);

            }
        });
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityMenu.this,SettingActivity.class);
                startActivity(intent);
            }
        });

        setToolbarName("ADHOHUB");
        drawer.closeDrawer(GravityCompat.START);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new DeshboardFragment()).commit();


    }

    public void setToolbarName(String name) {
        txt_name.setText(name);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

//        MenuItem itemCart = menu.findItem(R.id.about);

        return true;

    }


}
