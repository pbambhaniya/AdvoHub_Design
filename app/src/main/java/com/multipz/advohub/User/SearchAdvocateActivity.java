package com.multipz.advohub.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.multipz.advohub.Adapter.Adapter;
import com.multipz.advohub.Adapter.SearchAdvocateAdapter;
import com.multipz.advohub.Model.Model;
import com.multipz.advohub.Model.SearchAdvocateModel;
import com.multipz.advohub.R;
import com.multipz.advohub.activity.ChatAdvocateActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchAdvocateActivity extends AppCompatActivity {
    ImageView img_back;
    RecyclerView rv_search_lawyer;
    Context context;
    EditText edit_search_item;
    SearchAdvocateAdapter adapter;
    private List<SearchAdvocateModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_advocate);
        context = this;
        img_back = (ImageView) findViewById(R.id.img_back);
        edit_search_item = (EditText) findViewById(R.id.edit_search_item);

        rv_search_lawyer = (RecyclerView) findViewById(R.id.rv_search_lawyer);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        edit_search_item.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence constraint, int i, int i1, int i2) {
                adapter.filter(constraint.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        LawyerList();
    }

    private void LawyerList() {
        adapter = new SearchAdvocateAdapter(list, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv_search_lawyer.setLayoutManager(mLayoutManager);
        rv_search_lawyer.setItemAnimator(new DefaultItemAnimator());
        rv_search_lawyer.setAdapter(adapter);
        rv_search_lawyer.setNestedScrollingEnabled(false);
        adapter.setClickListener(new itemInClickListener());
        prepareExpertIn();
    }

    private void prepareExpertIn() {
        list.add(new SearchAdvocateModel("KK", "criminal", "", false));
        list.add(new SearchAdvocateModel("vraj", "Estate Planning Lawyer.", "", false));
        list.add(new SearchAdvocateModel("dn", "criminal", "", false));
        list.add(new SearchAdvocateModel("dhaval", "criminal", "", false));
        list.add(new SearchAdvocateModel("rajesh", "Intellectual Property Lawyer", "", false));
        list.add(new SearchAdvocateModel("dk", "criminal", "", false));
        list.add(new SearchAdvocateModel("vk", "criminal", "", false));
        list.add(new SearchAdvocateModel("kartik", "Corporate Lawyer", "", false));
        list.add(new SearchAdvocateModel("jk", "criminal", "", false));
        list.add(new SearchAdvocateModel("nk", "criminal", "", false));
        list.add(new SearchAdvocateModel("kamlesh", "Immigration Lawyer", "", false));
        list.add(new SearchAdvocateModel("Tl", "criminal", "", false));
        adapter.notifyDataSetChanged();
        adapter.filter("");
    }


    class itemInClickListener implements SearchAdvocateAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(SearchAdvocateActivity.this, SearchAdvocateDetailActivity.class);
            startActivity(intent);
        }
    }
}
