package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.SpSouSbean;
import jingou.jo.com.myshixun2xm.model.connector.ISouSuoModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public class SouSuoModel implements ISouSuoModel {
    @Override
    public void getSpxq(final NetWorkListener<SpSouSbean> spSouSbeanNetWorkListener, String keywords, String page) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.spss(keywords,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SpSouSbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SpSouSbean spSouSbean) {
                        spSouSbeanNetWorkListener.onSuccess(spSouSbean);
                    }
                });
    }
}
