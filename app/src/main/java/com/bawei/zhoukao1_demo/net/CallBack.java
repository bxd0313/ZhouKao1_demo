package com.bawei.zhoukao1_demo.net;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 19:59
 * @Description：描述信息
 */
public interface CallBack {
    void onSuccess(String result);
    void onError(String msg);
}
