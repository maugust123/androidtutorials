package com.example.morgan.basicapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {

    RelativeLayout layout;
    Button redButton;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.GREEN);

        //Button
        redButton = new Button(this);
        redButton.setText("Log In");
        redButton.setBackgroundColor(Color.RED);

        //Username input
        username = new EditText(this);
        username.setId(1);
        redButton.setId(2);


        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        //Give rules to position details

        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200, r.getDisplayMetrics());//Makes this same size on every device

        username.setWidth(px);

        //Add widgets to layout
        layout.addView(redButton, buttonDetails);
        layout.addView(username, usernameDetails);


        setContentView(layout);


        Button mainBack = (Button)findViewById(R.id.btnmainback);
        Button gridLayout = (Button)findViewById(R.id.btnlayout);

        mainBack.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //setContentView(R.layout.activity_main);

                        Intent intent =new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

        gridLayout.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //setContentView(R.layout.activity_grid_layout);
                      Main2Activity.this.startActivity(new Intent(Main2Activity.this, GridLayout.class));
                    }
                }
        );

    }
}
