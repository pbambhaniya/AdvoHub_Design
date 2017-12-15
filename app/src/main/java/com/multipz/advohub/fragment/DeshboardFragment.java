package com.multipz.advohub.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.multipz.advohub.Adapter.HighCourtAdapter;
import com.multipz.advohub.R;
import com.multipz.advohub.activity.ChatActivity;
import com.multipz.advohub.activity.ChatAdvocateActivity;
import com.multipz.advohub.activity.DictionaryActivity;
import com.multipz.advohub.activity.FeedBackActivity;
import com.multipz.advohub.activity.HighCourtActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeshboardFragment extends Fragment {
    RelativeLayout rel_newsfeed, rel_chat, rel_diary, rel_dictionary, rel_legislation, rel_drafting, rel_feedback;

    public DeshboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deshboard, container, false);


        rel_newsfeed = (RelativeLayout) view.findViewById(R.id.rel_newsfeed);
        rel_chat = (RelativeLayout) view.findViewById(R.id.rel_chat);
        rel_diary = (RelativeLayout) view.findViewById(R.id.rel_diary);
        rel_dictionary = (RelativeLayout) view.findViewById(R.id.rel_dictionary);
        rel_legislation = (RelativeLayout) view.findViewById(R.id.rel_legislation);
        rel_drafting = (RelativeLayout) view.findViewById(R.id.rel_drafting);
        rel_feedback = (RelativeLayout) view.findViewById(R.id.rel_feedback);


        rel_newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "HIII", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getActivity(), HighCourtActivity.class);
                startActivity(intent);
            }
        });


        rel_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "HIII", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getActivity(), DictionaryActivity.class);
                startActivity(intent);
            }
        });
        rel_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "HIII", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getActivity(), ChatAdvocateActivity.class);
                startActivity(intent);
            }
        });
        rel_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "HIII", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getActivity(), FeedBackActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }


}
