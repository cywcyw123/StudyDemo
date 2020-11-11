package com.example.studydemo.mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cyw on 2020/11/3
 */
public class TestMVPMVPActivity extends BaseMVPActivity<TestContract.view, TestPresenter> implements TestContract.view {
    String mText;
    @BindView(R.id.txt_data)
    TextView txtData;
    @BindView(R.id.btn_get_data)
    Button btnGetData;
    private ProgressDialog mProgressDialog;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    txtData.setText(mText);
                    break;
                case 2:
                    //txtContent.setText("删除完成");
            }
        }
    };

    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_base_mvp;
    }

    @Override
    protected void initView() {
        mProgressDialog=new ProgressDialog(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess(String message) {
        LogUtil.info(TestMVPMVPActivity.class,message);
        mText=message;
        mHandler.sendEmptyMessage(1);
        //txtData.setText(""+message);
    }



    @Override
    public Context getCurrentContext() {
        return null;
    }


    @OnClick({R.id.txt_data, R.id.btn_get_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_data:
                break;
            case R.id.btn_get_data:
                //txtData.setText("重新设置的数据");
                mPresenter.getData();
                break;
        }
    }
}
