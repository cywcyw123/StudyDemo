package com.example.studydemo.base;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

import com.example.studydemo.base.BaseMessage;


/**
 * @author huangzhangzhe
 */
public interface BaseMvpView {

    /**
     * 显示加载弹窗
     */
    void showLoading();

    /**
     * 隐藏加载弹窗
     */
    void hideLoading();


    /**
     * 加载数据失败
     * @param message
     */
    void onError(String message);

    /**
     * 加载数据成功
     * @param message
     */
    void onSuccess(String message);

//    /**
//     * 绑定Android生命周期 防止RxJava内存泄漏
//     *
//     * @param <T>
//     * @return
//     */
//    <T> AutoDisposeConverter<T> bindAutoDispose();


    /**
     * 获取LifecycleOwner
     * @return LifecycleOwner
     */
    LifecycleOwner getLifecycleOwner();


    /**
     * 获取上下文
     * @return
     */
    Context getCurrentContext();
}
