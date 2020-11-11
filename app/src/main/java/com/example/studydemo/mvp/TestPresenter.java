package com.example.studydemo.mvp;

import com.example.studydemo.base.BaseMvpPresenter;
import com.example.studydemo.util.LogUtil;

/**
 * Created by cyw on 2020/11/3
 */
public class TestPresenter extends BaseMvpPresenter<TestContract.view> implements TestContract.presenter {
    private TestModel testModel;

    @Override
    public void getData() {
        getView().showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //LifecycleOwner lifecycleOwner = getLifecycleOwner();
                testModel.getData(new DataListener() {
                    @Override
                    public void getDataSuccess(String msg) {
                        getView().hideLoading();
                        LogUtil.info(TestPresenter.class,msg);
                        getView().onSuccess(msg);
                    }

                    @Override
                    public void getDataError(String msg) {

                    }
                });
            }
        }).start();


    }

    @Override
    public void initModel() {
        super.initModel();
        testModel = new TestModel(getView().getCurrentContext());
    }

}
