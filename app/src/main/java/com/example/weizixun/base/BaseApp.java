package com.example.weizixun.base;

import android.app.Application;

public class BaseApp extends Application {
    private static BaseApp app;

    public BaseApp() {
        app = this;

        //appkey
        //5ede0d66978eea085d11dddb
    }

    public static BaseApp getApp() {
        return app;
    }
}
