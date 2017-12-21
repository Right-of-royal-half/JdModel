package jingou.jo.com.myshixun2xm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.GVAdapter;
import jingou.jo.com.myshixun2xm.presenter.FLleftpresenter;
import jingou.jo.com.myshixun2xm.view.connector.Ifragment2;

/**
 * Created by 杨杰 on 2017/12/14.
 */

public class fragmet01_item1 extends Fragment implements Ifragment2{
    private GridView gv;
    private GVAdapter adapter;
    private FLleftpresenter fLleftpresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vipfragment, null);
        fLleftpresenter = new FLleftpresenter(this);
        fLleftpresenter.getflleft();
        gv = view.findViewById(R.id.gv);
        return view;
    }

    @Override
    public void show(FlleftBean flleftBean) {
        List<FlleftBean.DataBean> list = flleftBean.getData();
        List<FlleftBean.DataBean> glist = new ArrayList<>();
             for(int i=0;i<10;i++){
                 FlleftBean.DataBean dataBean = list.get(i);
                 glist.add(dataBean);
             }
        adapter = new GVAdapter(glist, getContext());
        gv.setAdapter(adapter);
    }

    @Override
    public void showFeiShop(FLrightBean fLrightBean, String cid) {

    }
}
