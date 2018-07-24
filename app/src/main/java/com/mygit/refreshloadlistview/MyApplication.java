package com.mygit.refreshloadlistview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by admin on 2015/11/3.
 */
public class MyApplication extends Application {

    private static Context sApplicationContext;
    public static int count = 0;//消息数量

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return sApplicationContext;
    }
}
