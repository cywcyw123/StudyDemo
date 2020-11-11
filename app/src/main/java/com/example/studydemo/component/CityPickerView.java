package com.example.studydemo.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.studydemo.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyw on 2020/10/27
 */
public class CityPickerView extends View {
    private static final String TAG = "CityPickerView";
    private float mScrollDistance;
    private Paint mPaint = new Paint();
    private Context mContext;
    float mHalfWidth;
    float mHalfHight;
    private List<String> mDataList = new ArrayList<>();
    int index;

    /**
     * 选择结果回调接口
     */
    public interface OnSelectListener {
        void onSelect(View view, String selected, int position);
    }

    public CityPickerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mDataList.add("1");
        mDataList.add("2");
        mDataList.add("3");
        mDataList.add("4");
        mDataList.add("5");
        mDataList.add("6");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHalfWidth = getMeasuredWidth() / 2f;
        mHalfHight = getMeasuredHeight() / 2f;
        LogUtil.info(TAG, "控件宽度" + mHalfWidth);
        LogUtil.info(TAG, "控件高度" + mHalfHight);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_MOVE:
                LogUtil.info(TAG,"滑动距离"+event.getY());
                mScrollDistance=0;
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(sp2px(15));
        //居中显示
        mPaint.setTextAlign(Paint.Align.CENTER);
        //绘制中间text
        //绘制下方
        for (int i = 1; i < 20; i++) {
            float cc=i*29;
            mScrollDistance=cc+mHalfHight;
            canvas.drawText("你好"+i, mHalfWidth, mScrollDistance, mPaint);
        }
        LogUtil.info(TAG, "控件长度" + mDataList.size());
    }

    private void drawText(Canvas canvas, float mScrollDistance, String text) {
        canvas.drawText(text, mHalfWidth, mScrollDistance, mPaint);
    }

    public int sp2px(float spValue) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
