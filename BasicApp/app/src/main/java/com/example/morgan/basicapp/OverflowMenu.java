package com.example.morgan.basicapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OverflowMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow_menu);


        Bundle sharedData = getIntent().getExtras();
        if(sharedData == null){
            return;
        }

        String topMessage = sharedData.getString("TopText");

        TextView msg = (TextView)findViewById(R.id.txttransfer);
        msg.setText(topMessage);


        Button mainBack = (Button)findViewById(R.id.btnoverflowback);

        mainBack.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //setContentView(R.layout.activity_main);
                       OverflowMenu.this.startActivity(new Intent(OverflowMenu.this,memecreator.class));
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout overflowMenu = (RelativeLayout) findViewById(R.id.activity_overflow_menu);

        switch (item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                overflowMenu.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                overflowMenu.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                overflowMenu.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
