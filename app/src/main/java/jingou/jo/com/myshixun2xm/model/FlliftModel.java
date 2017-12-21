package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.model.connector.IFlliftModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class FlliftModel implements IFlliftModel {

    @Override
    public void left(final NetWorkListener<FlleftBean> flleftBeanNetWorkListener) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.flleftbean()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FlleftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        flleftBeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(FlleftBean flleftBean) {
                        flleftBeanNetWorkListener.onSuccess(flleftBean);
                    }
                });


    }
}
