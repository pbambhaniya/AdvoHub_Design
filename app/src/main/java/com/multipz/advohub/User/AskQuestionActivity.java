package com.multipz.advohub.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.multipz.advohub.R;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class AskQuestionActivity extends AppCompatActivity {
    private RangeSeekBar SeekBarrange;
    private ImageView img_back;
    private RelativeLayout img_notification, lnr_For, lnr_Problem_type;
    private LinearLayout lnr_range;
    private EditText edt_title, edt_ask_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        reference();
        init();


    }

    private void init() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
       /* SeekBarrange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ///length_edit.setText(Integer.toString(progress + 20));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });*/
    }

    private void reference() {
        SeekBarrange = (RangeSeekBar) findViewById(R.id.rangeSeekbar);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_notification = (RelativeLayout) findViewById(R.id.img_notification);
        lnr_For = (RelativeLayout) findViewById(R.id.lnr_For);
        lnr_Problem_type = (RelativeLayout) findViewById(R.id.lnr_Problem_type);
        lnr_range = (LinearLayout) findViewById(R.id.lnr_range);
        edt_title = (EditText) findViewById(R.id.edt_title);
        edt_ask_description = (EditText) findViewById(R.id.edt_ask_description);

    }
}
