package com.example.studydemo.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseMVPActivity<V extends BaseMvpView, T extends BaseMvpPresenter<V>> extends AppCompatActivity implements BaseMvpView {
    protected abstract boolean isTranslucentBars();

    int mColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        if (isTranslucentBars()) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (mColor == 0) {
                window.setStatusBarColor(Color.TRANSPARENT);
            } else {
                window.setStatusBarColor(mColor);
            }

            //适配凹凸异形屏
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
                getWindow().setAttributes(lp);
            }

        }
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
            mPresenter.initModel();
        }

    }

    /**
     * 初始化UI 必须返回
     *
     * @return 返回资源文件编号
     */
    protected abstract int initLayout();

    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract T createPresenter();

    /**
     * mvp中的p
     */
    protected T mPresenter;

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return BaseMVPActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}