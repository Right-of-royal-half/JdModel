package jingou.jo.com.myshixun2xm.presenter;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.model.CxgwModel;
import jingou.jo.com.myshixun2xm.model.connector.ICxgwModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.ICxgwActivity;

/**
 * Created by 杨杰 on 2017/12/20.
 */

public class CxgwPresenter {
    ICxgwModel iCxgwModel;
    final ICxgwActivity iCxgwActivity;

    public CxgwPresenter(ICxgwActivity iCxgwActivity) {
        this.iCxgwActivity = iCxgwActivity;
        iCxgwModel= new CxgwModel();
    }
    public void getWincx(final String uid){
        iCxgwModel.cx(new NetWorkListener<CxgwcBean>() {
            @Override
            public void onSuccess(CxgwcBean cxgwcBean) {
                List<CxgwcBean.DataBean> data = cxgwcBean.getData();
                List<List<CxgwcBean.DataBean.ListBean>> childList=new ArrayList<List<CxgwcBean.DataBean.ListBean>>();
                for (int i=0;i<data.size();i++){
                    List<CxgwcBean.DataBean.ListBean> list = data.get(i).getList();
                    childList.add(list);
                }
                iCxgwActivity.showList(data,childList,uid);

            }

            @Override
            public void onFailed(Exception e) {

            }
        },uid);
    }
}
