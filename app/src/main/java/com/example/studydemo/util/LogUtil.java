package com.example.studydemo.util;

import android.util.Log;


/**
 * log 方法
 * @author 张新锦
 */
public class LogUtil {
    public static void debug(String tag, String msg){
            Log.println(Log.DEBUG,tag,msg);
    }

    public static void debug(Class className, String msg){
        //if(BuildConfig.LOG_DEBUG){
            Log.println(Log.DEBUG,className.getSimpleName(),msg);
       // }
    }
    public static void info(String tag, String msg){
        //if(BuildConfig.LOG_DEBUG){
            Log.println(Log.INFO,tag,msg);
        //}
    }

    public static void info(Class className, String msg){
        //if(BuildConfig.LOG_DEBUG){
            Log.println(Log.INFO,className.getSimpleName(),msg);
      //  }
    }
    public static void error(String tag, String msg){
        //if(BuildConfig.LOG_DEBUG){
            Log.println(Log.ERROR,tag,msg);
      //  }
    }

    public static void error(Class className, String msg){
        //if(BuildConfig.LOG_DEBUG){
            Log.println(Log.ERROR,className.getSimpleName(),msg);
        //}
    }

}
