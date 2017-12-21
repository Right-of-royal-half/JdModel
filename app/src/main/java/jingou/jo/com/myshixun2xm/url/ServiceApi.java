package jingou.jo.com.myshixun2xm.url;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.Bean.LoginBean;
import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.Bean.SgouyeBean;
import jingou.jo.com.myshixun2xm.Bean.SpSouSbean;
import jingou.jo.com.myshixun2xm.Bean.ZcBean;
import jingou.jo.com.myshixun2xm.net.Api;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 杨杰 on 2017/12/12.
 */

public interface ServiceApi {
    @GET(Api.LOGIN)
    Observable<LoginBean> logbean(@Query("mobile") String mobile, @Query("password") String password);
    @GET(Api.ZC)
    Observable<ZcBean> zcbean(@Query("mobile") String mobile, @Query("password") String password);
    //首页
     @GET(Api.LBT)
     Observable<SgouyeBean> shouye();
    //分类
    @GET(Api.FLLEFT)
    Observable<FlleftBean> flleftbean();
    @GET(Api.RIGHT)
    Observable<FLrightBean> filerightbean(@Query("cid")  String cid);
    //商品分类接口
    @GET(Api.SPZFL)
    Observable<Flzflbean> flzflbean(@Query("pscid") String pscid);
    //详情
    @GET(Api.SPXQ)
    Observable<SPxiangqingBean> SpXqing(@Query("pid") String pid,@Query("source") String source);
    //搜索
    @GET(Api.SPSS)
    Observable<SpSouSbean> spss(@Query("keywords") String keywords,@Query("page") String page);
    //加入购物车
    @GET(Api.JRGW)
    Observable<JrGwcbean> jrgw(@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
    //查询您购物
    @GET(Api.CXGW)
    Observable<CxgwcBean> cxgw(@Query("uid") String uid,@Query("token") String token);
    //删除购物车数据
    @GET(Api.SCGW)
    Observable<JrGwcbean> scgw(@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
}
