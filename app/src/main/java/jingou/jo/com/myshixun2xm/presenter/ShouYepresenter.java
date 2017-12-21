package jingou.jo.com.myshixun2xm.presenter;

import jingou.jo.com.myshixun2xm.Bean.SgouyeBean;
import jingou.jo.com.myshixun2xm.model.ShouYeModel;
import jingou.jo.com.myshixun2xm.model.connector.IShouYeModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.Ishouyefragment1;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class ShouYepresenter {
     IShouYeModel iShouYeModel;
    final Ishouyefragment1 ishouyefragment1;

    public ShouYepresenter(Ishouyefragment1 ishouyefragment1) {
        this.ishouyefragment1 = ishouyefragment1;
        iShouYeModel =new ShouYeModel();
    }


    public void Win() {
        iShouYeModel.shouye(new NetWorkListener<SgouyeBean>() {
            @Override
            public void onSuccess(SgouyeBean sgouyeBean) {
                ishouyefragment1.show(sgouyeBean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
