package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.LoginBean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public interface IloginMOdel {
    public void login(String account, String pwd, NetWorkListener<LoginBean> loginBeanNetWorkListener);
}
