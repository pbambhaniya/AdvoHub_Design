package com.multipz.advohub.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.multipz.advohub.Adapter.BookMarkAdapter;
import com.multipz.advohub.Adapter.SearchAdvocateAdapter;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;

import java.util.ArrayList;
import java.util.List;

public class BookMarkActivity extends AppCompatActivity {
    ImageView img_back;
    RecyclerView rv_bookmark;
    Context context;
    BookMarkAdapter adapter;
    private List<SearchAdvocateModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);
        context = this;
        img_back = (ImageView) findViewById(R.id.img_back);

        rv_bookmark = (RecyclerView) findViewById(R.id.rv_bookmark);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        LawyerList();
    }
    private void LawyerList() {
        adapter = new BookMarkAdapter(context,list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_bookmark.setLayoutManager(mLayoutManager);
        rv_bookmark.setItemAnimator(new DefaultItemAnimator());
        rv_bookmark.setAdapter(adapter);
//        rv_bookmark.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        BookMarkData();
    }
    private void BookMarkData() {
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("vraj", "Estate Planning Lawyer.", "", false));
        list.add(new SearchAdvocateModel("dn", "criminal", "", false));
        list.add(new SearchAdvocateModel("dhaval", "criminal", "", false));
        list.add(new SearchAdvocateModel("rajesh", "Intellectual Property Lawyer", "", false));
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("kartik", "Corporate Lawyer", "", false));
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("kamlesh", "Immigration Lawyer", "", false));
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        adapter.notifyDataSetChanged();
    }
    class itemInClickListener implements BookMarkAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

}
