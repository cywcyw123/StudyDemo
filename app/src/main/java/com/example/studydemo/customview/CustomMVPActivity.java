package com.example.studydemo.customview;

import androidx.lifecycle.LifecycleOwner;

import android.content.Context;
import android.os.Bundle;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;

public class CustomMVPActivity extends BaseMVPActivity {

    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_custom);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_custom;
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