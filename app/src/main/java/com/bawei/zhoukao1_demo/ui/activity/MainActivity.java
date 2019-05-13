package com.bawei.zhoukao1_demo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.zhoukao1_demo.R;
import com.bawei.zhoukao1_demo.adapter.HomeAdapter;
import com.bawei.zhoukao1_demo.base.BaseActivity;
import com.bawei.zhoukao1_demo.bean.HomeBean;
import com.bawei.zhoukao1_demo.mvp.home.HomePresenterImpl;
import com.bawei.zhoukao1_demo.mvp.home.IHomeContract;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IHomeContract.IHomeView {
     private ListView listView;
     private IHomeContract.IHomePresenter presenter;
     private List<HomeBean.CommodityList> lists=new ArrayList<>();
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initControl() {
      listView=findViewById(R.id.listView);
    }

    @Override
    public void initData() {
       presenter=new HomePresenterImpl();
       presenter.attach(this);
       String path="http://172.17.8.100/small/commodity/v1/commodityList";
       presenter.requestList(path);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void showList(String result) {
        Gson gson=new Gson();
        HomeBean homeBean = gson.fromJson(result, HomeBean.class);
        lists.addAll(homeBean.result.rxxp.commodityList);
        listView.setAdapter(new HomeAdapter(lists,this));
    }
}
