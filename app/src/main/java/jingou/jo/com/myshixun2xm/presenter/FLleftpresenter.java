package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.model.FlliftModel;
import jingou.jo.com.myshixun2xm.model.connector.IFlliftModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.Ifragment2;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class FLleftpresenter {
    final Ifragment2 ifragment2;
    IFlliftModel iFlliftModel;
    public FLleftpresenter(Ifragment2 ifragment2) {
        this.ifragment2 = ifragment2;
        iFlliftModel= new FlliftModel();
    }
    public void getflleft(){
        iFlliftModel.left(new NetWorkListener<FlleftBean>() {
            @Override
            public void onSuccess(FlleftBean flleftBean) {
                ifragment2.show(flleftBean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
