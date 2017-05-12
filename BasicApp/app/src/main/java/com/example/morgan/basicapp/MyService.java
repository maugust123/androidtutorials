package com.example.morgan.basicapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = "example.morgan.basicapp";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "OnStartCommand method called");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {

                    long futureTime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis() < futureTime) {
                        synchronized (this) {

                            try {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            } catch (Exception ex) {
                            }
                        }
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy method called");
        super.onDestroy();
    }
}
