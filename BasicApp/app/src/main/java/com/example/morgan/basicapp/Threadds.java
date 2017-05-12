package com.example.morgan.basicapp;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Threadds extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){

            TextView text = (TextView) findViewById(R.id.txthello);
            text.setText("Hello Anna");
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadds);
    }

    protected  void btnHello(View view){

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                long feautureTime = System.currentTimeMillis()+10000;
                while (System.currentTimeMillis() < feautureTime){

                    synchronized (this){
                        try {
                            wait(feautureTime - System.currentTimeMillis());
                        }catch (Exception ex){}
                    }
                }

                handler.sendEmptyMessage(0);
            }
        };

       Thread thread = new Thread(runnable);
        thread.start();



    }
}
