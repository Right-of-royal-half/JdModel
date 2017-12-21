package jingou.jo.com.myshixun2xm.model;

import android.util.Log;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.model.connector.IFLrightModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class FLrightModel implements IFLrightModel {
    @Override
    public void getShopShop(final NetWorkListener<FLrightBean> netWorkListener, String cid) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.filerightbean(cid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FLrightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        netWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(FLrightBean fLrightBean) {
                        netWorkListener.onSuccess(fLrightBean);
                        Log.d("bbbb",fLrightBean.getData().get(0).getName());
                    }
                });
    }
}
