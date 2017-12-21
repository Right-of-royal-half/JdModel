package jingou.jo.com.myshixun2xm.net;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public interface Api {
    public static final String HOST="https://www.zhaoapi.cn/";
    public static final String LOGIN="user/login";
    public static final String ZC="user/reg";
    //首页
    public static final String LBT="ad/getAd";
    //分类
    public static final String FLLEFT="product/getCatagory";
    public static final String RIGHT="product/getProductCatagory";
    //商品子分类
    public static final String SPZFL="/product/getProducts";
    //商品详情
    public static final String SPXQ="product/getProductDetail";
    //商品搜索
    public static final String SPSS="product/searchProducts";
    //加入购物车
    public static final String JRGW="product/addCart";
    //查询购物车
    public static final String CXGW="product/getCarts";
    //删除购物车
    public static final String SCGW="product/deleteCart";
}
