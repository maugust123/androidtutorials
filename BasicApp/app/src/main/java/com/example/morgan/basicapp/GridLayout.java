package com.example.morgan.basicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);


        Button mainBack = (Button)findViewById(R.id.btnback);

        mainBack.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //setContentView(R.layout.activity_main);
                        GridLayout.this.startActivity(new Intent(GridLayout.this,memecreator.class));
                    }
                }
        );
    }
}
