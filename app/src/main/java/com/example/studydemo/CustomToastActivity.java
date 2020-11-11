package com.example.studydemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studydemo.base.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomToastActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
        ButterKnife.bind(this);
        adapter=new Adapter(this);
        List<String> list=new ArrayList<>();
        for (int i=0;i<3;i++){
            list.add("01");
            list.add("02");
            list.add("03");
        }
        adapter.setDatas(list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        rv.addItemDecoration(new MyDecoration(CustomToastActivity.this));
    }
}