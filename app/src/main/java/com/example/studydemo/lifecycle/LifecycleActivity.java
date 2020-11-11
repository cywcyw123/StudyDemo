package com.example.studydemo.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import android.os.Bundle;
import android.util.Log;

import com.example.studydemo.R;
import com.example.studydemo.util.LogUtil;

public class LifecycleActivity extends AppCompatActivity {
    //MyLocationListener myLocationListener;
    Test test;
    private static final String TAG = "LifecycleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        // 就只需要这一行代码，简洁吧
        //getLifecycle().addObserver(new MyObserver());
        //Lifecycle lifecycle = getLifecycle();
        LifecycleOwner mmlifecycleOwner = getLifecycleOwner();
        test = new Test(mmlifecycleOwner);
    }

    private LifecycleOwner getLifecycleOwner() {
        return LifecycleActivity.this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        //myLocationListener.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //myLocationListener.stop();
    }

}