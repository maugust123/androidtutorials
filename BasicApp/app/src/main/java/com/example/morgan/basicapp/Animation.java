package com.example.morgan.basicapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Animation extends AppCompatActivity {

    ViewGroup morgansLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        morgansLayout = (ViewGroup) findViewById(R.id.activity_animation);

        morgansLayout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View view, MotionEvent event){
                moveButton();
                return true;
            }
        });
    }

    public void onClick(View view){
        startActivity(new Intent(this, memecreator.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void moveButton(){
        View btnAmimate = findViewById(R.id.btnanimation);

        TransitionManager.beginDelayedTransition(morgansLayout);

        //Change the position of the button

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        btnAmimate.setLayoutParams(positionRules);

        //Change size of the button

        ViewGroup.LayoutParams sizeRules = btnAmimate.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height  = 300;
        btnAmimate.setLayoutParams(sizeRules);
    }


}
