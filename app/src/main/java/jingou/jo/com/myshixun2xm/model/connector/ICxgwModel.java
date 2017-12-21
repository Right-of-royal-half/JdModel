package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/20.
 */

public interface ICxgwModel {
    public void cx(NetWorkListener<CxgwcBean> cxgwcBeanNetWorkListener,String uid);
}
