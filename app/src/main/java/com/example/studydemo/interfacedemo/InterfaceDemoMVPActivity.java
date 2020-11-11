package com.example.studydemo.interfacedemo;

import androidx.lifecycle.LifecycleOwner;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;

public class InterfaceDemoMVPActivity extends BaseMVPActivity {
    InterfaceDemo interfaceDemo;
    private TextView txtContent;
    String mContent;
    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_interface_demo);
        txtContent=findViewById(R.id.txt_content);
        interfaceDemo = new InterfaceDemo(new InterfaceDemo.CallBack() {
            @Override
            public void call(String name) {
                Log.i("wdsax", "传回的数据：" + name);
                mContent=name;
            }
        });
        txtContent.setText(mContent);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_interface_demo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BaseMvpPresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return null;
    }

    @Override
    public Context getCurrentContext() {
        return null;
    }
}