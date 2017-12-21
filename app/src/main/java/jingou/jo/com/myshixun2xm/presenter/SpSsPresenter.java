package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.SpSouSbean;
import jingou.jo.com.myshixun2xm.model.SouSuoModel;
import jingou.jo.com.myshixun2xm.model.connector.ISouSuoModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.ISsuoActivity;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public class SpSsPresenter {
 final ISsuoActivity iSsuoActivity;
    ISouSuoModel iSouSuoModel;
    public SpSsPresenter(ISsuoActivity iSsuoActivity) {
        this.iSsuoActivity = iSsuoActivity;
        iSouSuoModel= new SouSuoModel();
    }
    public void getWin(final String keywords){
        iSouSuoModel.getSpxq(new NetWorkListener<SpSouSbean>() {
            @Override
            public void onSuccess(SpSouSbean spSouSbean) {
                iSsuoActivity.showxq(spSouSbean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        },keywords,1+"");
    }
}
