package jingou.jo.com.myshixun2xm.model.connector;

import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/17.
 */

public interface ISpzflModel {
    public void Spzfl(NetWorkListener<Flzflbean> flzflbeanNetWorkListener,String pscid);
}
