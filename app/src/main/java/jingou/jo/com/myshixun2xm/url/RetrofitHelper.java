package jingou.jo.com.myshixun2xm.url;

import jingou.jo.com.myshixun2xm.net.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;
    static {

        initokhttp();

    }

    private static void initokhttp() {
        if (okHttpClient==null){

            synchronized (RetrofitHelper.class){

                if (okHttpClient==null){

                    okHttpClient= new OkHttpClient.Builder()

                            .build();

                }

            }

        }
    }
    public static  ServiceApi getserviceapi(){

        if (serviceApi==null){

            synchronized (RetrofitHelper.class){

                if (serviceApi==null){

                    serviceApi = onCreatApi(ServiceApi.class, Api.HOST);
                }

            }

        }

        return serviceApi;

    }

    public static <T> T onCreatApi(Class<T> tClass,String url){

        Retrofit retrofit = new Retrofit.Builder()

                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .addConverterFactory(GsonConverterFactory.create())

                .baseUrl(url)

                .build();

        return retrofit.create(tClass);

    }



}
