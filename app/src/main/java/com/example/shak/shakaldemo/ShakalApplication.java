package com.example.shak.shakaldemo;

import android.app.Application;

import com.example.shak.shakaldemo.util.UtilLog;

/**
 * Created by Shak on 2/6/17.
 */

public class ShakalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
