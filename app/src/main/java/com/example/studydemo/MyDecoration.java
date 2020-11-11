package com.example.studydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studydemo.util.LogUtil;

/**
 * Created by cyw on 2020/11/5
 */
class MyDecoration extends RecyclerView.ItemDecoration {
    Context context;
    //    @Override
//    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//        //outRect.set(0, 0, 0, 20);
//    }
    private Drawable mDividingLineDrawable;

    public MyDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = 0;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        mDividingLineDrawable=context.getDrawable(R.drawable.home_profile_bg_main_card_20dp_blue);
        int count = parent.getChildCount();
        parent.getPaddingLeft();
        for (int i = 0; i < count; i++) {
            View view = parent.getChildAt(i);
            int top = view.getTop();
            int bottom = view.getBottom();
            int left = view.getLeft();
            int right = view.getRight();
            mDividingLineDrawable.setBounds(left , top - 40, right, top);
            LogUtil.info("sacw","top:"+top);
            LogUtil.info("sacw","bottom:"+bottom);
            LogUtil.info("sacw","left:"+left);
            LogUtil.info("sacw","right:"+right);
            mDividingLineDrawable.draw(c);
        }
    }
}