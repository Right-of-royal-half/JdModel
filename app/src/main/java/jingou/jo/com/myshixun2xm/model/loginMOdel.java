package jingou.jo.com.myshixun2xm.model;

import jingou.jo.com.myshixun2xm.Bean.LoginBean;
import jingou.jo.com.myshixun2xm.model.connector.IloginMOdel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.url.RetrofitHelper;
import jingou.jo.com.myshixun2xm.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public class loginMOdel implements IloginMOdel {

    @Override
    public void login(String account, String pwd, final NetWorkListener<LoginBean> loginBeanNetWorkListener) {
        ServiceApi serviceApi = RetrofitHelper.getserviceapi();
         serviceApi.logbean(account, pwd)
                .subscribeOn(Schedulers.io())

                .unsubscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loginBeanNetWorkListener.onFailed((Exception) e);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginBeanNetWorkListener.onSuccess(loginBean);
                    }
                });

    }
}
