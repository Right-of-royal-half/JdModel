package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.model.GwcModel;
import jingou.jo.com.myshixun2xm.model.connector.IGwcModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.Ixqfeagment;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public class Jrgwpresenter {
    IGwcModel iGwcModel;
    final Ixqfeagment iJrgwcActivity;

    public Jrgwpresenter(Ixqfeagment iJrgwcActivity) {
        this.iJrgwcActivity = iJrgwcActivity;
        iGwcModel = new GwcModel();
    }

    public void getgw(final String pid, final String uid){
        iGwcModel.login(pid,uid, new NetWorkListener<JrGwcbean>() {
            @Override
            public void onSuccess(JrGwcbean jrGwcbean) {
                iJrgwcActivity.showAddCar(jrGwcbean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
