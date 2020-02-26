package com.bawei.wangyi20200226.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.wangyi20200226.R;
import com.bawei.wangyi20200226.base.BaseActivity;

public class Main2Activity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tv= findViewById(R.id.tv_id);
        tv.setText(name);


    }

    @Override
    protected void initData() {


    }
}
