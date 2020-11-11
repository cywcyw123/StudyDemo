package com.example.studydemo.interfacedemo;

import android.content.Context;

/**
 * Created by cyw on 2020/10/20
 */
public class InterfaceDemo {
    private CallBack mCallBack;
    private String name="我是回传出来的数据";
    public interface CallBack{
        void call(String name);
    }

    public InterfaceDemo(CallBack callBack) {
        mCallBack=callBack;
        test();
        //mCallBack.call(name);
    }
    private void test(){
        mCallBack.call(name);
    }
}
