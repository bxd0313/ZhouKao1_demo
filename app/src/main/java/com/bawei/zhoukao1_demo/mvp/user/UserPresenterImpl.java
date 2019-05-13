package com.bawei.zhoukao1_demo.mvp.user;

import com.bawei.zhoukao1_demo.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 20:21
 * @Description：描述信息
 */
public class UserPresenterImpl implements IUserContract.IUserPresenter {
    private IUserContract.IUserView view;
    private IUserContract.IUserModel model;
    @Override
    public void attach(IUserContract.IUserView view) {
        this.view=view;
        model=new UserModelImpl();
    }

    @Override
    public void detach() {
        if(view!=null){
            view=null;
        }
        if(model!=null){
            model=null;
        }
    }

    @Override
    public void register(String name, String pwd) {
         model.register(name, pwd, new CallBack() {
             @Override
             public void onSuccess(String result) {
                 view.registerSuccess(result);
             }

             @Override
             public void onError(String msg) {

             }
         });
    }

    @Override
    public void login(String name, String pwd) {
         model.login(name, pwd, new CallBack() {
             @Override
             public void onSuccess(String result) {
                 view.loginSuccess(result);
             }

             @Override
             public void onError(String msg) {

             }
         });
    }
}
