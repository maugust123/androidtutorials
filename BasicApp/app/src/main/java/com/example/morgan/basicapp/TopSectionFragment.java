package com.example.morgan.basicapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Morgan on 4/7/2017.
 */

public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;


    TopSectionListener activityCommander;

    public interface TopSectionListener{
       public  void CreateMeme(String topString, String bottomString);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            activityCommander = (TopSectionListener)activity;
        }catch (ClassCastException ex){

            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section_fragment, container,false);

        topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        final Button button = (Button)view.findViewById(R.id.btnButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClicked(view);
            }
        });

        return view;

    }

    public void ButtonClicked(View view){

        activityCommander.CreateMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}
