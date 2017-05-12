package com.example.morgan.basicapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class memecreator extends AppCompatActivity implements TopSectionFragment.TopSectionListener {

    private String userTopInput;//I want to use it to transfer data to another intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memecreator);
    }

    //This gets called by the top fragment when the user clicks the button
    @Override
    public void CreateMeme(String topString, String bottomString) {

        userTopInput = topString;
        BottomPictureFragment bottomPictureFragment = (BottomPictureFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        bottomPictureFragment.setMemeText(topString, bottomString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout overflowMenu = (RelativeLayout) findViewById(R.id.activity_memecreator);

        switch (item.getItemId()){
            case R.id.menu_main2activity:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

               memecreator.this.startActivity(new Intent(memecreator.this, Main2Activity.class));
                return true;
            case R.id.menu_swiper:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                memecreator.this.startActivity(new Intent(memecreator.this, Swiper.class));
                return true;
            case R.id.menu_gridlayout:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                memecreator.this.startActivity(new Intent(memecreator.this, GridLayout.class));
                return true;
            case R.id.menu_overflow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i =new Intent(this, OverflowMenu.class);
                i.putExtra("TopText",userTopInput);

                startActivity(i);
                return true;
            case R.id.menu_animation:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                memecreator.this.startActivity(new Intent(memecreator.this, Animation.class));
                return true;
            case R.id.menu_threads:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                memecreator.this.startActivity(new Intent(this, Threadds.class));
                return true;

            case R.id.menu_boundService:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                memecreator.this.startActivity(new Intent(this, BoundActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
