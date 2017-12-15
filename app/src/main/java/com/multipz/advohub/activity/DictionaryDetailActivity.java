package com.multipz.advohub.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.R;

public class DictionaryDetailActivity extends AppCompatActivity {
    TextView txt_word_name;
    String name;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_detail);

        txt_word_name = (TextView) findViewById(R.id.txt_word_name);
        img_back = (ImageView) findViewById(R.id.img_back);


        name = getIntent().getStringExtra("Name");

        txt_word_name.setText(name);


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
