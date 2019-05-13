package com.bawei.zhoukao1_demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhoukao1_demo.R;
import com.bawei.zhoukao1_demo.bean.HomeBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 21:13
 * @Description：描述信息
 */
public class HomeAdapter extends BaseAdapter {
     private List<HomeBean.CommodityList> list;
     private Context context;

    public HomeAdapter(List<HomeBean.CommodityList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.textView=convertView.findViewById(R.id.textView);
            holder.imageView=convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).commodityName);
        Glide.with(context).load(list.get(position).masterPic).into(holder.imageView);
        return convertView;
    }
  class ViewHolder{
        ImageView imageView;
        TextView textView;
  }
}
