package com.example.morgan.basicapp;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    private final IBinder myBinder = new MyLocalBinder();

    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        return simpleDateFormat.format(new Date());
    }


    public class MyLocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }
}
