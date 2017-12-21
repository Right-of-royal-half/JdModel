package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.model.connector.ISpzflModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/17.
 */

public class SpzflModel implements ISpzflModel {
    @Override
    public void Spzfl(final NetWorkListener<Flzflbean> flzflbeanNetWorkListener, String pscid) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.flzflbean(pscid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Flzflbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                      flzflbeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(Flzflbean flzflbean) {
                        flzflbeanNetWorkListener.onSuccess(flzflbean);
                    }
                });
    }
}
