package com.example.studydemo.mvp;

/**
 * Created by cyw on 2020/11/3
 */
public interface DataListener {
    void getDataSuccess(String msg);
    void getDataError(String msg);
}
