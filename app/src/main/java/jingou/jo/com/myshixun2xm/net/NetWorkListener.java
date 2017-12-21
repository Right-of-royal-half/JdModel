package jingou.jo.com.myshixun2xm.net;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public interface NetWorkListener<T> {
    public void onSuccess(T t);

    public void onFailed(Exception e);
}
