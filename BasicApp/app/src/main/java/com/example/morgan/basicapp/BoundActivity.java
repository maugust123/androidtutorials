package com.example.morgan.basicapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BoundActivity extends AppCompatActivity {

    BoundService morgansService;
    boolean isBound = false;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onShowTimeClick(View view){
        String currentTime = morgansService.getCurrentTime();
        TextView txtTime = (TextView)findViewById(R.id.txttime);
        txtTime.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, morgansConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection morgansConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) iBinder;
            morgansService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            isBound = false;
        }
    };
}
