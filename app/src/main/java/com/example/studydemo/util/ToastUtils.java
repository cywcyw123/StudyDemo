package com.example.studydemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author 张新锦
 */
public class ToastUtils {

    private static Toast mToast;

    public static void showToast(Context context, String content){
        mToast = Toast.makeText(context,content, Toast.LENGTH_LONG);
        mToast.show();
    }

}
