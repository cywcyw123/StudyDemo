package com.example.studydemo;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studydemo.base.BaseRecyclerViewAdapter;
import com.example.studydemo.util.LogUtil;

/**
 * Created by cyw on 2020/11/6
 */
public class Adapter extends BaseRecyclerViewAdapter<String> {
    private Context context;
    public Adapter(Context mContext) {
        super(mContext);
        this.context=mContext;
    }

//    @Override
//    public int getItemViewType(int uiPosition) {
//       return uiPosition;
//    }

    @Override
    public void bindData(BaseViewHolder holder, String data, int position) {
        //holder.itemView.setBackground(context.getResources().getDrawable());
        //holder.itemView.
        //int itemViewType = holder.getItemViewType();
        //LogUtil.info("Adapter","itemViewType:"+itemViewType);
    }


    @Override
    public int getEmptyLayoutId() {
        return 0;
    }

    @Override
    public int getHeaderLayoutId() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_profile_share_recycle_item;
    }


    @Override
    public void bindHeaderData(BaseViewHolder holder) {

    }

    @Override
    public boolean isHeaderOnlyLine() {
        return false;
    }


}
