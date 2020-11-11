package com.example.studydemo.recycleview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studydemo.R;
import com.example.studydemo.base.BaseRecyclerViewAdapter;
import com.example.studydemo.util.LogUtil;

/**
 * Created by cyw on 2020/10/23
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdapter<User> {
    private Context mContext;
    private onItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context mContext) {
        super(mContext);
        this.mContext=mContext;
    }

    @Override
    public int getEmptyLayoutId() {
        return 0;
    }

    @Override
    public int getHeaderLayoutId() {
        return R.layout.recycle_item_header;
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycle_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, User data, int position) {
        User user=new User();
        user.setAge(data.getAge());
        user.setName(data.getName());
        user.setSex(data.getSex());
        String sAge= String.valueOf(data.getAge());
        TextView tvName= (TextView) holder.getView(R.id.tv_name);
        TextView tvAge= (TextView) holder.getView(R.id.tv_age);
        TextView tvSex= (TextView) holder.getView(R.id.tv_sex);
        tvAge.setText(sAge);
        tvName.setText(user.getName());
        tvSex.setText(user.getSex());
        tvAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.clickAge(user.getAge());
            }
        });
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.clickName(user.getName());
                tvName.setTextColor(Color.RED);
            }
        });
        tvSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.clickSex(user.getSex());
            }
        });
    }

    @Override
    public void bindHeaderData(BaseViewHolder holder) {

    }

    @Override
    public boolean isHeaderOnlyLine() {
        return true;
    }
    public interface onItemClickListener{
        //点击姓名
        void clickName(String name);
        //点击性别
        void clickSex(String sex);
        //点击年龄
        void clickAge(int age);
    }
    public void setOnClickListener(onItemClickListener onClickListener){
        this.onItemClickListener=onClickListener;
    }
}
