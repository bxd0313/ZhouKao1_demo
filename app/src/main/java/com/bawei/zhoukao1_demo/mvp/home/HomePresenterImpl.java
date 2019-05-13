package com.bawei.zhoukao1_demo.mvp.home;

import com.bawei.zhoukao1_demo.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 21:02
 * @Description：描述信息
 */
public class HomePresenterImpl implements IHomeContract.IHomePresenter {
    private IHomeContract.IHomeView view;
    private IHomeContract.IHomeModel model;
    @Override
    public void attach(IHomeContract.IHomeView view) {
      this.view=view;
      model=new HomeModelImpl();
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
    public void requestList(String url) {
        model.requestList(url, new CallBack() {
            @Override
            public void onSuccess(String result) {
                view.showList(result);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
