package com.example.morgan.basicapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Morgan on 5/10/2017.
 */

public class AndroidService extends IntentService{

    public static final String TAG = "example.morgan.basicapp";

    public AndroidService() {
        super("AndroidService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does

        Log.i(TAG, "The service has now started");
    }
}
