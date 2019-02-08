package com.example.jokesandroidlibrary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokesFragment extends Fragment {


    public static JokesFragment newInstance() {
        return new JokesFragment();
    }
    TextView gce_result_show;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.jokes_fragment, container, false);
        Intent intent = getActivity().getIntent();
        /*
        String joke = i.getStringExtra("jokes");
        TextView textView = v.findViewById(R.id.jokes_text_view);
        textView.setText(joke);
        */
        gce_result_show = (TextView) view.findViewById(R.id.joke_text_view);

        if(intent.hasExtra("gce_result")){
        String gce_result = getActivity().getIntent().getStringExtra("gce_result");
        gce_result_show.setText(gce_result);

        }

        return view;

    }


}
