package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.model.connector.ICxgwModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/20.
 */

public class CxgwModel implements ICxgwModel {

    @Override
    public void cx(final NetWorkListener<CxgwcBean> cxgwcBeanNetWorkListener, String uid) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.cxgw(uid,"BF5BA7E8C55AB0507A2E716B9E4CA3C3")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CxgwcBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CxgwcBean cxgwcBean) {
                        cxgwcBeanNetWorkListener.onSuccess(cxgwcBean);
                    }
                });
    }
}
