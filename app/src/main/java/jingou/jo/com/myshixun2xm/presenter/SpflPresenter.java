package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.model.SpzflModel;
import jingou.jo.com.myshixun2xm.model.connector.ISpzflModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.SpflActivity;
import jingou.jo.com.myshixun2xm.view.connector.ISpflActivity;

/**
 * Created by 杨杰 on 2017/12/17.
 */

public class SpflPresenter {
    final ISpflActivity iSpflActivity;
    ISpzflModel ispzflModel;

    public SpflPresenter(SpflActivity iSpflActivity) {
        this.iSpflActivity = iSpflActivity;
        ispzflModel = new SpzflModel();
    }
    public void getWinsp(final String pscid){
        ispzflModel.Spzfl(new NetWorkListener<Flzflbean>() {
            @Override
            public void onSuccess(Flzflbean flzflbean) {
                        iSpflActivity.showFlzflbean(flzflbean,pscid);
            }

            @Override
            public void onFailed(Exception e) {

            }
        },pscid);
    }
}
