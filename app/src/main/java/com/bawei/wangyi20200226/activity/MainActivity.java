package com.bawei.wangyi20200226.activity;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bawei.wangyi20200226.R;
import com.bawei.wangyi20200226.adapter.MyAdapter;
import com.bawei.wangyi20200226.base.BaseActivity;
import com.bawei.wangyi20200226.bean.BeanInfo;
import com.bawei.wangyi20200226.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView lv;
    String path="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //找控件
        lv = findViewById(R.id.lv);

    }
    @Override
    protected void initData() {

        //加载数据
        VolleyUtils.getInstance().doGet(path, new VolleyUtils.CallBack() {

            private List<BeanInfo.ResultBean.RxxpBean.CommodityListBean> commodityList;

            @Override
            public void Success(String json) {
                Log.i("xxx",json);
                Gson gson = new Gson();
                BeanInfo beanInfo = gson.fromJson(json, BeanInfo.class);
                BeanInfo.ResultBean result = beanInfo.getResult();
                BeanInfo.ResultBean.RxxpBean rxxp = result.getRxxp();
                commodityList = rxxp.getCommodityList();

                MyAdapter myAdapter = new MyAdapter(MainActivity.this, commodityList);
                lv.setAdapter(myAdapter);

                //条目点击
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        BeanInfo.ResultBean.RxxpBean.CommodityListBean commodityListBean = commodityList.get(position);
                        String commodityName = commodityListBean.getCommodityName();

                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("name",commodityName);
                        startActivity(intent);


                    }
                });

            }

            @Override
            public void Error(String msg) {

            }
        });

    }
}
