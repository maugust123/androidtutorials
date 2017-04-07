package com.example.morgan.basicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button nav = (Button) findViewById(R.id.btninterface);
        nav.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //setContentView(R.layout.activity_grid_layout);
                        MainActivity.this.startActivity(new Intent(MainActivity.this, GridLayout.class));
                    }
                }
        );

        nav.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        TextView txtview = (TextView) findViewById(R.id.lbltitle);
                        txtview.setText("Holly crap, that was a long click");

                        return true;
                    }
                }
        );

        Button swiper = (Button) findViewById(R.id.btnswiper);

        swiper.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //setContentView(R.layout.activity_swiper);
                        MainActivity.this.startActivity(new Intent(MainActivity.this, Swiper.class));
                    }
                }
        );
    }
}
