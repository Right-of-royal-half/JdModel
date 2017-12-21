package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.model.connector.IGwcModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/19.
 */

public class GwcModel implements IGwcModel {
    @Override
    public void login(String uid, String pid, final NetWorkListener<JrGwcbean> jrGwcbeanNetWorkListener) {
        final ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.jrgw(uid,pid,"BF5BA7E8C55AB0507A2E716B9E4CA3C3")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JrGwcbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JrGwcbean jrGwcbean) {
                        jrGwcbeanNetWorkListener.onSuccess(jrGwcbean);
                    }
                });
    }
}
