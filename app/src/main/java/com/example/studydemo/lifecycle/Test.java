package com.example.studydemo.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.studydemo.util.LogUtil;

/**
 * Created by cyw on 2020/11/3
 */
public class Test {
    LifecycleOwner mLifecycleOwner;

    public Test(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        LogUtil.info(Test.class, "test:start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        LogUtil.info(Test.class, "test:stop");
    }
}
