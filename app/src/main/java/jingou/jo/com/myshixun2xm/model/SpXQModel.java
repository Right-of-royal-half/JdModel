package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.model.connector.ISpXQModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/18.
 */

public class SpXQModel implements ISpXQModel {
    @Override
    public void getSpxq(final NetWorkListener<SPxiangqingBean> sPxiangqingBeanNetWorkListener, String pid) {
        final ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.SpXqing(pid,"android")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SPxiangqingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        sPxiangqingBeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(SPxiangqingBean sPxiangqingBean) {
                        sPxiangqingBeanNetWorkListener.onSuccess(sPxiangqingBean);
                    }
                });
    }
}
