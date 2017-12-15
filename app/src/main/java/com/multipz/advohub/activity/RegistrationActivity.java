package com.multipz.advohub.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.multipz.advohub.R;


public class RegistrationActivity extends AppCompatActivity {
    Button btn_create_profile;
    RadioButton radioMale, radioFemale, radiomessage, radiocall, radioconsulte,rb_criminal,rb_family,rb_hindi,rb_english,rb_high_court,rb_supreme_court;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        btn_create_profile = (Button) findViewById(R.id.btn_create_profile);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radiomessage = (RadioButton) findViewById(R.id.radiomessage);
        radiocall = (RadioButton) findViewById(R.id.radiocall);
        radioconsulte = (RadioButton) findViewById(R.id.radioconsulte);

        rb_criminal = (RadioButton) findViewById(R.id.rb_criminal);
        rb_family = (RadioButton) findViewById(R.id.rb_family);
        rb_hindi = (RadioButton) findViewById(R.id.rb_hindi);
        rb_english = (RadioButton) findViewById(R.id.rb_english);
        rb_high_court = (RadioButton) findViewById(R.id.rb_high_court);
        rb_supreme_court = (RadioButton) findViewById(R.id.rb_supreme_court);

        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        btn_create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, ActivityMenu.class);
                startActivity(intent);
            }
        });

        radioMale.setButtonDrawable(R.drawable.check_box);
        radioFemale.setButtonDrawable(R.drawable.check_box);

        radiomessage.setButtonDrawable(R.drawable.check_box);
        radiocall.setButtonDrawable(R.drawable.check_box);
        radioconsulte.setButtonDrawable(R.drawable.check_box);



        rb_criminal.setButtonDrawable(R.drawable.check_box);
        rb_family.setButtonDrawable(R.drawable.check_box);

        rb_hindi.setButtonDrawable(R.drawable.check_box);
        rb_english.setButtonDrawable(R.drawable.check_box);

        rb_high_court.setButtonDrawable(R.drawable.check_box);
        rb_supreme_court.setButtonDrawable(R.drawable.check_box);



    }

}
