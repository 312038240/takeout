package com.jim.takeout;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2018/3/11.
 */

public class MakeOutApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getContext() {
        return context;
    }
}
