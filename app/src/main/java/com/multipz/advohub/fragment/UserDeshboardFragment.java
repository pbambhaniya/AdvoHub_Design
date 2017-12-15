package com.multipz.advohub.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.multipz.advohub.R;
import com.multipz.advohub.User.AskQuestionActivity;
import com.multipz.advohub.User.BookMarkActivity;
import com.multipz.advohub.User.CaseListActivity;
import com.multipz.advohub.User.PostCaseActivity;
import com.multipz.advohub.User.PostCasesActivity;
import com.multipz.advohub.User.SearchAdvocateActivity;
import com.multipz.advohub.activity.ChatWindowActivity;
import com.multipz.advohub.activity.HighCourtActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDeshboardFragment extends Fragment {

    RelativeLayout rel_search_advocate, rel_chat_advocate, rel_ask, rel_bookmark, rel_newsfeed, rel_postcase, rel_case_list;

    public UserDeshboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_deshboard, container, false);

        rel_search_advocate = (RelativeLayout) view.findViewById(R.id.rel_search_advocate);
        rel_chat_advocate = (RelativeLayout) view.findViewById(R.id.rel_chat_advocate);
        rel_ask = (RelativeLayout) view.findViewById(R.id.rel_ask);
        rel_bookmark = (RelativeLayout) view.findViewById(R.id.rel_bookmark);
        rel_newsfeed = (RelativeLayout) view.findViewById(R.id.rel_newsfeed);
        rel_case_list = (RelativeLayout) view.findViewById(R.id.rel_case_list);
        rel_postcase = (RelativeLayout) view.findViewById(R.id.rel_postcase);

        rel_search_advocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchAdvocateActivity.class);
                startActivity(intent);
            }
        });
        rel_chat_advocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChatWindowActivity.class);
                startActivity(intent);
            }
        });
        rel_newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HighCourtActivity.class);
                startActivity(intent);
            }
        });

        rel_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AskQuestionActivity.class);
                startActivity(intent);
            }
        });
        rel_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookMarkActivity.class);
                startActivity(intent);
            }
        });

        rel_case_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaseListActivity.class);
                startActivity(intent);
            }
        });
        rel_postcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostCaseActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
