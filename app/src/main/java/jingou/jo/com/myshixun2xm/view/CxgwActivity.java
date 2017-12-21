package jingou.jo.com.myshixun2xm.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.model.connector.ICxgwModel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.presenter.CxgwPresenter;
import jingou.jo.com.myshixun2xm.view.connector.ICxgwActivity;

public class CxgwActivity extends AppCompatActivity implements ICxgwModel {

    private CxgwPresenter cxgwPresenter;
    private int uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cxgw);
        cxgwPresenter = new CxgwPresenter((ICxgwActivity) this);
        cxgwPresenter.getWincx(uid+"");

    }

    @Override
    public void cx(NetWorkListener<CxgwcBean> cxgwcBeanNetWorkListener, String uid) {

    }
}
