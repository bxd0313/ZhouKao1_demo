package com.bawei.zhoukao1_demo.bean;

import java.util.List;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 21:12
 * @Description：描述信息
 */
public class HomeBean {
    public Result result;
    public class Result{
        public Rxxp rxxp;
    }
    public class Rxxp{
        public List<CommodityList> commodityList;
    }
    public class CommodityList{
        public String commodityName;
        public String masterPic;
    }
}
