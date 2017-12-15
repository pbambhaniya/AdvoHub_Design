package com.multipz.advohub.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.multipz.advohub.R;

public class UserFeedbackActivity extends AppCompatActivity {
    private ImageView img_back;
    private TextView txtassign_lawyer_name, txtDivorceLawyer, btn_give_feedback;
    private RatingBar feedbackRating;
    private EditText edt_feedback_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feedback);

        reference();
        init();

    }

    private void init() {

    }

    private void reference() {
        img_back = (ImageView) findViewById(R.id.img_back);
        txtassign_lawyer_name = (TextView) findViewById(R.id.txtassign_lawyer_name);
        txtDivorceLawyer = (TextView) findViewById(R.id.txtDivorceLawyer);
        btn_give_feedback = (TextView) findViewById(R.id.btn_give_feedback);
        feedbackRating = (RatingBar) findViewById(R.id.feedbackRating);
        edt_feedback_description = (EditText) findViewById(R.id.edt_feedback_description);

    }
}
