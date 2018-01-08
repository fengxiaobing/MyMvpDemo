package com.bing.mymvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class App extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = (App) getApplicationContext();

    }
    public static App getContext() {
        return (App) App.mContext;
    }
}
