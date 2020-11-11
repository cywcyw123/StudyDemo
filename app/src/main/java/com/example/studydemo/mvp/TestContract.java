package com.example.studydemo.mvp;

import com.example.studydemo.base.BaseMvpView;

/**
 * Created by cyw on 2020/11/3
 */
public interface TestContract {
    interface model {
        void getData(DataListener dataListener);
    }

    interface presenter {
        void getData();
    }

    interface view extends BaseMvpView {
//        void showLoading();
//
//        void dismissLoading();
//
//        void getDataSuccess(String msg);

    }


}
