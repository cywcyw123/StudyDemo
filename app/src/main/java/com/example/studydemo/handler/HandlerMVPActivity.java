package com.example.studydemo.handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;

public class HandlerMVPActivity extends BaseMVPActivity {
    private Button btnDownload,btnDelete;
    private TextView txtContent;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    txtContent.setText("下载完成");
                    break;
                case 2:
                    txtContent.setText("删除完成");
            }
        }
    };

    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_handler);
        btnDownload=findViewById(R.id.btn_download);
        btnDelete=findViewById(R.id.btn_delete);
        txtContent=findViewById(R.id.txt_content);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setText("开始下载");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setText("开始删除");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(2);
                    }
                }).start();
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_handler;
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