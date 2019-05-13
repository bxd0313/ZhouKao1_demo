package com.bawei.zhoukao1_demo.mvp.home;

import com.bawei.zhoukao1_demo.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 20:54
 * @Description：描述信息
 */
public interface IHomeContract {
    public interface IHomeView{
        void showList(String result);
    }
    public interface IHomeModel{
        void requestList(String url, CallBack callBack);
    }
    public interface IHomePresenter{
        void attach(IHomeView view);
        void detach();
        void requestList(String url);
    }
}
