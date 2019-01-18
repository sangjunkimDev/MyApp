package com.project.sangjun.myapp.util;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.github.ajalt.reprint.core.Reprint;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();



        Reprint.initialize(this, new Reprint.Logger() {
            @Override
            public void log(String message) {
                Log.d("Reprint", message);
            }

            @Override
            public void logException(Throwable throwable, String message) {
                Log.e("Reprint", message, throwable);
            }
        });


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
