package com.bawei.zhoukao1_demo.mvp.home;

import com.bawei.zhoukao1_demo.net.CallBack;
import com.bawei.zhoukao1_demo.net.HttpUtil;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 21:00
 * @Description：描述信息
 */
public class HomeModelImpl implements IHomeContract.IHomeModel {
     private HttpUtil httpUtil;
     public HomeModelImpl(){
         httpUtil=HttpUtil.getInstance();
    }
    @Override
    public void requestList(String url, CallBack callBack) {
          httpUtil.doHttpGet(url,callBack);
    }
}
