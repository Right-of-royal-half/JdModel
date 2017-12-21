package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.ZcBean;
import jingou.jo.com.myshixun2xm.model.connector.IRegister;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class Register implements IRegister {
    @Override
    public void register(String account, String pwd, final NetWorkListener<ZcBean> zcBeanNetWorkListener) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        serviceApi.zcbean(account,pwd)
                .subscribeOn(Schedulers.io())

                .unsubscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZcBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        zcBeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(ZcBean zcBean) {
                        zcBeanNetWorkListener.onSuccess(zcBean);
                    }
                });
    }
}
