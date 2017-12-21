package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.ZcBean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public interface IRegister {
    public void register(String account, String pwd, NetWorkListener<ZcBean> zcBeanNetWorkListener);
}
