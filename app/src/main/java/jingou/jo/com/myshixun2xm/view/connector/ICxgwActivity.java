package jingou.jo.com.myshixun2xm.view.connector;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;

/**
 * Created by 杨杰 on 2017/12/20.
 */

public interface ICxgwActivity {
    public void showList(List<CxgwcBean.DataBean> grouplist, List<List<CxgwcBean.DataBean.ListBean>> childlist,String uid);
}
