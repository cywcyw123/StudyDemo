package com.example.studydemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.studydemo.R;

/**
 * Created by cyw on 2020/10/20
 */
public class CustomView extends View {
    private Paint mPaint = new Paint();// 创建一个画笔;
    private int mColor = Color.RED; //默认为红色
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        //加载自定义属性集合CustomView
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
//        //解析CustomView中自定义的属性custom_color，id为R.styleable.CustomView_custom_color，如果没有就默认为红色
//        mColor = a.getColor(R.styleable.CustomView_custom_color, Color.RED);
//        //释放资源，方便下次使用
//        a.recycle();
//
//        //初始化画笔的参数
//        mPaint.setColor(Color.RED);// 设置画笔颜色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
//        Path path=new Path();
//
//        canvas.drawPath(path,mPaint);
        canvas.drawLine(60,100,100,100,mPaint);
        canvas.drawText("你好",10,30,mPaint);
        canvas.drawText("我是2",10,80,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
