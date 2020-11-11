package com.example.studydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LifecycleOwner;

import com.example.studydemo.CustomToast.ToastUtil;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.CommonTitleBar;
import com.example.studydemo.component.ComponentActivity;
import com.example.studydemo.customview.CustomMVPActivity;
import com.example.studydemo.handler.HandlerMVPActivity;
import com.example.studydemo.interfacedemo.InterfaceDemoMVPActivity;
import com.example.studydemo.lifecycle.LifecycleActivity;
import com.example.studydemo.mvp.TestMVPMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;
import com.example.studydemo.recycleview.BaseRecycleViewMVPActivity;
import com.example.studydemo.util.LogUtil;
import com.example.studydemo.util.ToastUtils;
import com.example.studydemo.viewpagefragment.ViewPageFragmentMVPActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMVPActivity extends BaseMVPActivity {
    int i = 0;
    Intent intent;
    @BindView(R.id.btn_rxjava)
    Button btnRxjava;
    @BindView(R.id.btn_custom_view)
    Button btnCustomView;
    @BindView(R.id.btn_fish)
    Button btnFish;
    @BindView(R.id.btn_interface)
    Button btnInterface;
    @BindView(R.id.commonTitleBar)
    CommonTitleBar commonTitleBar;
    @BindView(R.id.btn_view_page_fragment)
    Button btnViewPageFragment;
    @BindView(R.id.btn_handler)
    Button btnHandler;
    @BindView(R.id.btn_base_recycle_adapter)
    Button btnBaseRecycleAdapter;
    @BindView(R.id.btn_component)
    Button btnComponent;
    @BindView(R.id.btn_navigation_view)
    Button btnNavigationView;
    @BindView(R.id.btn_lifecycle)
    Button btnLifecycle;

    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LogUtil.info(MainMVPActivity.class, "i:" + i);
        initView();
        LogUtil.info(MainMVPActivity.class, "i:" + i);
        initListener();
        //ToastUtil.showImageToas(this,"你好");
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    private void initListener() {

    }

    public void initView() {
        i = 2;
        commonTitleBar.setOnTitleBarClickListener(new CommonTitleBar.OnClickListener() {
            @Override
            public void onBackPress() {
                ToastUtils.showToast(MainMVPActivity.this, "点击返回");
            }

            @Override
            public void onClosePress() {
                ToastUtils.showToast(MainMVPActivity.this, "点击关闭");
            }

            @Override
            public void onSettingPress() {
                ToastUtils.showToast(MainMVPActivity.this, "点击左");
            }

            @Override
            public void onClickRightText() {
                ToastUtils.showToast(MainMVPActivity.this, "点击右");
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BaseMvpPresenter createPresenter() {
        return null;
    }

    private void goIntent() {
        startActivity(intent);
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

    @OnClick({R.id.btn_rxjava, R.id.btn_custom_view, R.id.btn_fish, R.id.btn_interface, R.id.commonTitleBar, R.id.btn_view_page_fragment, R.id.btn_handler, R.id.btn_base_recycle_adapter, R.id.btn_component, R.id.btn_navigation_view,R.id.btn_lifecycle,R.id.btn_mvp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rxjava:
            case R.id.btn_fish:
//                intent=new Intent(MainMVPActivity.this,CustomToastActivity.class);
//                goIntent();
                ToastUtil.showImageToas(MainMVPActivity.this,"点击鱼");
                break;
            case R.id.commonTitleBar:
            case R.id.btn_navigation_view:
                break;
            case R.id.btn_mvp:
                intent = new Intent(MainMVPActivity.this, TestMVPMVPActivity.class);
                goIntent();
                break;
            case R.id.btn_lifecycle:
                intent = new Intent(MainMVPActivity.this, LifecycleActivity.class);
                goIntent();
                break;
            case R.id.btn_custom_view:
//                intent = new Intent(MainMVPActivity.this, CustomMVPActivity.class);
//                goIntent();
                ToastUtil.showImageToas(MainMVPActivity.this,"点击自定义view");
                break;
            case R.id.btn_interface:
                intent = new Intent(MainMVPActivity.this, InterfaceDemoMVPActivity.class);
                goIntent();
                break;
            case R.id.btn_view_page_fragment:
                intent = new Intent(MainMVPActivity.this, ViewPageFragmentMVPActivity.class);
                goIntent();
                break;
            case R.id.btn_handler:
                intent = new Intent(MainMVPActivity.this, HandlerMVPActivity.class);
                goIntent();
                break;
            case R.id.btn_base_recycle_adapter:
                intent = new Intent(MainMVPActivity.this, BaseRecycleViewMVPActivity.class);
                goIntent();
                break;
            case R.id.btn_component:
                intent = new Intent(MainMVPActivity.this, ComponentActivity.class);
                goIntent();
                break;
        }
    }


}