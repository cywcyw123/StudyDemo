package com.example.studydemo.CustomToast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studydemo.R;

/**
 * Created by cyw on 2020/11/5
 */
public class ToastUtil {
    //显示文本+图片的Toast
    public static void showImageToas(Context context, String message) {
        View toastview = LayoutInflater.from(context).inflate(R.layout.toast_test, null);
        TextView text = (TextView) toastview.findViewById(R.id.tv_message);
        text.setText(message);    //要提示的文本
        Toast toast = new Toast(context);   //上下文
        toast.setGravity(Gravity.CENTER, 0, 0);   //位置居中
        toast.setDuration(Toast.LENGTH_SHORT);  //设置短暂提示
        toast.setView(toastview);   //把定义好的View布局设置到Toast里面
        toast.show();
    }
    //显示文本的Toast
//    public static void showTextToas(Context context,String message){
//        View toastview= LayoutInflater.from(context).inflate(R.layout.toast_text_layout,null);
//        TextView text = (TextView) toastview.findViewById(R.id.tv_message);
//        text.setText(message);
//        Toast toast=new Toast(context);
//        toast.setGravity(Gravity.CENTER,0,0);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(toastview);
//        toast.show();
//
//    }
}
