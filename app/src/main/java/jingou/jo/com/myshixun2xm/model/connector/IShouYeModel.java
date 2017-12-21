package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.SgouyeBean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public interface IShouYeModel {
    public void shouye(NetWorkListener<SgouyeBean> sgouyeBeanNetWorkListener);
}
