package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public interface IGwcModel {
    public void login(String pid, String uid, NetWorkListener<JrGwcbean> jrGwcbeanNetWorkListener);
}
