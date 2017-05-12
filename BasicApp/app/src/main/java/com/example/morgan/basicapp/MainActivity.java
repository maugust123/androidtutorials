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

        Intent intent = new Intent(this, AndroidService.class);
        startService(intent);//This starts the Intent service called AndroidService

        Intent i = new Intent(this, MyService.class);
        startService(i);


        final Button login = (Button) findViewById(R.id.btnlogin);
        login.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //setContentView(R.layout.activity_grid_layout);
                        MainActivity.this.startActivity(new Intent(MainActivity.this, memecreator.class));
                    }
                }
        );

        login.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        TextView txtview = (TextView) findViewById(R.id.lbltitle);
                        txtview.setText("Holly crap, that was a long click");

                        return true;
                    }
                }
        );

//        Button swiper = (Button) findViewById(R.id.btnswiper);
//
//        swiper.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //setContentView(R.layout.activity_swiper);
//                        MainActivity.this.startActivity(new Intent(MainActivity.this, Swiper.class));
//                    }
//                }
//        );

//        Button fragment = (Button) findViewById(R.id.btnfragmentstrigar);
//
//        fragment.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //setContentView(R.layout.activity_swiper);
//                        MainActivity.this.startActivity(new Intent(MainActivity.this, memecreator.class));
//                    }
//                }
//        );
//
//        Button menu = (Button) findViewById(R.id.btnoverflowmenu);
//
//        menu.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //setContentView(R.layout.activity_swiper);
//                        MainActivity.this.startActivity(new Intent(MainActivity.this, OverflowMenu.class));
//                    }
//                }
//        );
    }
}
