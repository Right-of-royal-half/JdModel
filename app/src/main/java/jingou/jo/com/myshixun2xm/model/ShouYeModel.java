package jingou.jo.com.myshixun2xm.model;

import android.util.Log;

import jingou.jo.com.myshixun2xm.Bean.SgouyeBean;
import jingou.jo.com.myshixun2xm.model.connector.IShouYeModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class ShouYeModel implements IShouYeModel {
    @Override
    public void shouye(final NetWorkListener<SgouyeBean> sgouyeBeanNetWorkListener) {
        final ServiceApi serviceApi = RetrofitHelper.getserviceapi();
        Observable<SgouyeBean> shouye = serviceApi.shouye();

               shouye .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SgouyeBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("aaaaaaaaaaaaaaa","ss");
                    }

                    @Override
                    public void onError(Throwable e) {
                        sgouyeBeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(SgouyeBean sgouyeBean) {
                        sgouyeBeanNetWorkListener.onSuccess(sgouyeBean);
                    }
                });
    }
}
