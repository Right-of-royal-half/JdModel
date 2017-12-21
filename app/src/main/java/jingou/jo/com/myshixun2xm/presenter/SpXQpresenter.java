package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.model.SpXQModel;
import jingou.jo.com.myshixun2xm.model.connector.ISpXQModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.Ixqfeagment;

/**
 * Created by 杨杰 on 2017/12/18.
 */

public class SpXQpresenter {
    final Ixqfeagment ixqfeagment;
    ISpXQModel iSpXQModel;
    public SpXQpresenter(Ixqfeagment ixqfeagment) {
        this.ixqfeagment = ixqfeagment;
        iSpXQModel = new SpXQModel();
    }
    public void getwin(final String pid){
        iSpXQModel.getSpxq(new NetWorkListener<SPxiangqingBean>() {
            @Override
            public void onSuccess(SPxiangqingBean sPxiangqingBean) {
                ixqfeagment.showxq(sPxiangqingBean,pid);
            }

            @Override
            public void onFailed(Exception e) {

            }
        },pid);
    }
}
