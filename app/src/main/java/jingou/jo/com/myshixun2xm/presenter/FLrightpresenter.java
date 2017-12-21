package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.model.FLrightModel;
import jingou.jo.com.myshixun2xm.model.connector.IFLrightModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.Ifragment2;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class FLrightpresenter {
    final Ifragment2 ifragment2;
    IFLrightModel ifLrightModel;
    public FLrightpresenter(Ifragment2 ifragment2) {
        this.ifragment2 = ifragment2;
        ifLrightModel=new FLrightModel();
    }
    public void getWin(final String cid){
        ifLrightModel.getShopShop(new NetWorkListener<FLrightBean>() {
            @Override
            public void onSuccess(FLrightBean fLrightBean) {
                ifragment2.showFeiShop(fLrightBean,cid);
            }

            @Override
            public void onFailed(Exception e) {

            }
        },cid);
    }
}
