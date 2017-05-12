package com.example.morgan.basicapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Morgan on 4/7/2017.
 */



public class BottomPictureFragment extends Fragment {

    private static TextView topmemetext, bottommemetex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);


        topmemetext = (TextView)view.findViewById(R.id.txttopMemetext);
        bottommemetex = (TextView)view.findViewById(R.id.txtbottomMemetext);

        return view;
    }

    public void setMemeText(String top, String bottom){
        topmemetext.setText(top);
        bottommemetex.setText(bottom);
    }
}
