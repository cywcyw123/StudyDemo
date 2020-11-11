package com.example.studydemo.lifecycle;

import android.content.Context;

import com.example.studydemo.util.LogUtil;

import javax.security.auth.callback.Callback;

/**
 * Created by cyw on 2020/11/3
 */
public class MyLocationListener {
    public MyLocationListener(Context context) {
        LogUtil.info(MyLocationListener.class,"创建方法");
        // ...
    }

    void start() {
        LogUtil.info(MyLocationListener.class,"start方法");
        // connect to system location service
    }

    void stop() {
        LogUtil.info(MyLocationListener.class,"stop方法");
        // disconnect from system location service
    }
}
