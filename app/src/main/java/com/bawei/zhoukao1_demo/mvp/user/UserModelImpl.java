package com.bawei.zhoukao1_demo.mvp.user;

import com.bawei.zhoukao1_demo.net.CallBack;
import com.bawei.zhoukao1_demo.net.HttpUtil;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 20:01
 * @Description：描述信息
 */
public class UserModelImpl implements IUserContract.IUserModel {
     private HttpUtil httpUtil;
     public UserModelImpl(){
         httpUtil=HttpUtil.getInstance();
     }
    @Override
    public void register(String name, String pwd, CallBack callBack) {
        String registerUrl="http://172.17.8.100/small/user/v1/register";
        httpUtil.doHttpPost(registerUrl,name,pwd,callBack);
    }

    @Override
    public void login(String name, String pwd, CallBack callBack) {
        String loginUrl = "http://172.17.8.100/small/user/v1/login";
        httpUtil.doHttpPost(loginUrl,name,pwd,callBack);
    }
}
