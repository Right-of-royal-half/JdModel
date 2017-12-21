package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.SpSouSbean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public interface ISouSuoModel {
    public void getSpxq(NetWorkListener<SpSouSbean> spSouSbeanNetWorkListener, String keywords,String page);
}
