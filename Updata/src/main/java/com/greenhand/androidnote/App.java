package com.greenhand.androidnote;

import android.app.Application;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/5/8 22:21
 * e-mail:13967189624@163.com
 * description:
 */

public class App extends Application {

    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }
}
