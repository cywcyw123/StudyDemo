package com.example.studydemo.mvp;

import android.content.Context;

/**
 * Created by cyw on 2020/11/3
 */
public class TestModel implements TestContract.model {
    Context mContext;
    @Override
    public void getData(DataListener listener) {
        listener.getDataSuccess("获取数据成功，我是回来的数据");
    }

    public TestModel(Context context) {
        this.mContext=context;
    }
}
