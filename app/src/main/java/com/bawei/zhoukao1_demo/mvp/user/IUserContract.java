package com.bawei.zhoukao1_demo.mvp.user;

import com.bawei.zhoukao1_demo.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 19:43
 * @Description：用户相关的契约类
 *
 */
public interface IUserContract {

    public interface IUserView{
        void registerSuccess(String result);
        void loginSuccess(String result);
    }
    public interface IUserModel{
        void register(String name,String pwd,CallBack callBack);
        void login(String name,String pwd,CallBack callBack);
    }
    public interface IUserPresenter{
        void attach(IUserView view);
        void detach();
        void register(String name,String pwd);
        void login(String name,String pwd);
    }
}
