package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/18.
 */

public interface ISpXQModel {
    public void getSpxq(NetWorkListener<SPxiangqingBean> sPxiangqingBeanNetWorkListener,String pid);
}
