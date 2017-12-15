package com.multipz.advohub.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.advohub.R;

public class AsignCaseLawyerActivity extends AppCompatActivity {
    private ImageView img_back, img_dp;
    private TextView txtassign_lawyer_name, btn_assign, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asign_case_lawyer);


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
    }

    private void reference() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_dp = (ImageView) findViewById(R.id.img_dp);
        txtassign_lawyer_name = (TextView) findViewById(R.id.txtassign_lawyer_name);
        btn_assign = (TextView) findViewById(R.id.btn_assign);
        btn_cancel = (TextView) findViewById(R.id.btn_cancel);

    }
}
