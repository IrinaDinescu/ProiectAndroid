package com.example.proiectandroid.classes;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Application sApplication;

    public static Application getAppication(){
        return  sApplication;
    }

    public static Context getContext(){
        return getAppication().getApplicationContext();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        sApplication = this;
    }
}
