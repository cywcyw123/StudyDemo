package com.example.studydemo.recycleview;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseMVPActivity;
import com.example.studydemo.base.BaseMvpPresenter;
import com.example.studydemo.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseRecycleViewMVPActivity extends BaseMVPActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    List<User> userList;
    @Override
    protected boolean isTranslucentBars() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base_recycle_view);
        initView();
        initData();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_base_recycle_view;
    }

    public void initData() {
        User user=new User("张三",20,"男");
        User user1=new User("李四",22,"女");
        User user2=new User("王五",23,"男");
        userList.add(user);
        userList.add(user2);
        userList.add(user1);
        mRecyclerViewAdapter.setDatas(userList);
    }

    @Override
    protected BaseMvpPresenter createPresenter() {
        return null;
    }

    public void initView() {
        userList=new ArrayList<>();
        mRecyclerView=findViewById(R.id.rv_demo);
        mRecyclerViewAdapter=new RecyclerViewAdapter(BaseRecycleViewMVPActivity.this);
        mRecyclerViewAdapter.setDatas(userList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(BaseRecycleViewMVPActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setOnClickListener(new RecyclerViewAdapter.onItemClickListener() {
            @Override
            public void clickName(String name) {
                ToastUtils.showToast(BaseRecycleViewMVPActivity.this,"点击的姓名为："+name);
            }

            @Override
            public void clickSex(String sex) {
                ToastUtils.showToast(BaseRecycleViewMVPActivity.this,"点击的性别为："+sex);

            }

            @Override
            public void clickAge(int age) {
                ToastUtils.showToast(BaseRecycleViewMVPActivity.this,"点击的年龄为："+age);
            }
        });
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