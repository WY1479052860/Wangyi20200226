package com.bawei.wangyi20200226.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangyi20200226.R;
import com.bawei.wangyi20200226.activity.MainActivity;
import com.bawei.wangyi20200226.bean.BeanInfo;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 适配器类
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<BeanInfo.ResultBean.RxxpBean.CommodityListBean> commodityList;

    public MyAdapter(Context context, List<BeanInfo.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @Override
    public int getCount() {
        return commodityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        holder=new ViewHolder();
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder.iv=convertView.findViewById(R.id.iv);
            holder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        BeanInfo.ResultBean.RxxpBean.CommodityListBean commodityListBean = commodityList.get(position);
        String commodityName = commodityListBean.getCommodityName();
        String masterPic = commodityListBean.getMasterPic();


        holder.tv.setText(commodityName);
        Glide.with(context).load(masterPic).into(holder.iv);
        return convertView;
    }
    private class ViewHolder{
        private TextView tv;
        private ImageView iv;

    }
}
