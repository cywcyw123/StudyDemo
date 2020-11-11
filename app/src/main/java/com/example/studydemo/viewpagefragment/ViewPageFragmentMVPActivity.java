package com.example.studydemo.viewpagefragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPageFragmentMVPActivity extends BaseMVPActivity {

    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @BindView(R.id.txt_menu_one)
    TextView txtMenuOne;
    @BindView(R.id.txt_menu_two)
    TextView txtMenuTwo;
    @BindView(R.id.txt_menu_three)
    TextView txtMenuThree;
    @BindView(R.id.view_page_content)
    ViewPager myViewPager;
    private final int menuOne = 0;
    private final int menuTwo = 1;
    private final int menuThree = 2;
    List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_page_fragment);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_view_page_fragment;
    }

    @Override
    protected void initView() {

    }

    public void initData() {
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);
        txtMenuOne.setBackgroundColor(Color.RED);
    }

    @Override
    protected BaseMvpPresenter createPresenter() {
        return null;
    }

    private void initListener() {
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomTabSelectState(menuOne);
                        break;
                    case 1:
                        bottomTabSelectState(menuTwo);
                        break;
                    case 2:
                        bottomTabSelectState(menuThree);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bottomTabSelectState(int flag) {
        myViewPager.setCurrentItem(flag);
        switch (flag) {
            case 0:
                txtMenuTwo.setBackgroundColor(Color.WHITE);
                txtMenuOne.setBackgroundColor(Color.RED);
                txtMenuThree.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                txtMenuOne.setBackgroundColor(Color.WHITE);
                txtMenuTwo.setBackgroundColor(Color.RED);
                txtMenuThree.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                txtMenuOne.setBackgroundColor(Color.WHITE);
                txtMenuThree.setBackgroundColor(Color.RED);
                txtMenuTwo.setBackgroundColor(Color.WHITE);
                break;
        }

    }

    @OnClick({R.id.txt_menu_one, R.id.txt_menu_two, R.id.txt_menu_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_menu_one:
                bottomTabSelectState(menuOne);
                break;
            case R.id.txt_menu_two:
                bottomTabSelectState(menuTwo);
                break;
            case R.id.txt_menu_three:
                bottomTabSelectState(menuThree);
                break;
        }
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