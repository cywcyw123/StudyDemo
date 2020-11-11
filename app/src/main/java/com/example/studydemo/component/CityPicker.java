package com.example.studydemo.component;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.studydemo.R;

/**
 * Created by cyw on 2020/10/27
 */
public class CityPicker implements View.OnClickListener {
    private Dialog mDialog;
    private Context mContext;
    @Override
    public void onClick(View v) {

    }

    public CityPicker(Context context) {
        mContext=context;
        initView();
    }

    private void initView() {
        mDialog = new Dialog(mContext, R.style.date_picker_dialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //mDialog.set
        mDialog.setContentView(R.layout.picker_city);
        mDialog.show();
        //设置弹窗位置
        setGravity(Gravity.BOTTOM);
    }
    /**
     *
     * 设置弹窗位置
     * */
    private void setGravity(int gravity) {
        Window window = mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = gravity;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }
    }
   public void show(){

   }
}
