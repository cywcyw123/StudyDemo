package com.example.studydemo.base;

import androidx.lifecycle.LifecycleOwner;

import com.example.studydemo.util.LogUtil;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huangzhangzhe
 */
public class BaseMvpPresenter<T extends BaseMvpView>{


    /**
     * 初始化model
     */
    public void initModel()
    {

    }

    /**
     * View接口类型的弱引用
     */
    private Reference<T> mViewRef;

    //动态代理的View类
    private T mProxyView;


    /**
     * 绑定视图
     * @param mView 视图
     */
    public void attachView(T mView) {

        mViewRef = new WeakReference<>(mView);

        //动态代理类
        mProxyView = (T) Proxy.newProxyInstance(mView.getClass().getClassLoader(), mView.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 动态代理每次都会执行这个方法，调用的是被代理的对象（就是mView）
                if (mViewRef == null || mViewRef.get() == null) {
                    return null ;
                }else{
                    LogUtil.debug(BaseMvpPresenter.class.getSimpleName(),"method name : "+method.getName());
                    return method.invoke(mViewRef.get(), args);
                }
            }
        });
    }

    public T getView() {
        return mProxyView;
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解绑视图
     */
    public void detachView() {

        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 获取LifecycleOwner
     * @return LifecycleOwner
     */
    public LifecycleOwner getLifecycleOwner()
    {
        return (LifecycleOwner) mViewRef.get();
    }

}
