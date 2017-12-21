package jingou.jo.com.myshixun2xm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.Right_itemadpter;
import jingou.jo.com.myshixun2xm.adpter.Rightadpter;
import jingou.jo.com.myshixun2xm.adpter.leftfladpter;
import jingou.jo.com.myshixun2xm.presenter.FLleftpresenter;
import jingou.jo.com.myshixun2xm.presenter.FLrightpresenter;
import jingou.jo.com.myshixun2xm.view.SpflActivity;
import jingou.jo.com.myshixun2xm.view.connector.Ifragment2;

/**
 * Created by 杨杰 on 2017/10/25.
 */

public class Fragment02 extends Fragment implements Ifragment2{

    private RecyclerView rlv;
    private RecyclerView rlv1;
    private RecyclerView rlv2;
    private ArrayList<FLrightBean.DataBean> list;
    private FLrightpresenter fLrightpresenter;
    private List<FlleftBean.DataBean> data1;
    private List<String> list2 = new ArrayList<>();
    private jingou.jo.com.myshixun2xm.adpter.leftfladpter leftfladpter;
    private View view;
    private Banner banner;
    private RecyclerView rlv3;
    private TextView tv;
    private List<FLrightBean.DataBean.ListBean> list1;
    private Rightadpter rightadpter;
    private Right_itemadpter right_itemadpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        rlv = view.findViewById(R.id.rlv);
        tv = view.findViewById(R.id.tv);
        rlv3 = view.findViewById(R.id.rv);
        FLleftpresenter fLleftpresenter = new FLleftpresenter(this);
        fLleftpresenter.getflleft();
        fLrightpresenter = new FLrightpresenter(this);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv3.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;

    }

    @Override
    public void show(final FlleftBean flleftBean) {
        data1 = flleftBean.getData();
        List<FlleftBean.DataBean> data = flleftBean.getData();
        final leftfladpter leftfladpter = new leftfladpter(data, getActivity());
        rlv.setAdapter(leftfladpter);
        leftfladpter.setOnClienkListener(new leftfladpter.OnClienkListener() {
            @Override
            public void onClick(FlleftBean.DataBean dataBean1) {
                int cid = dataBean1.getCid();
                Toast.makeText(getContext(), cid + "", Toast.LENGTH_SHORT).show();
                fLrightpresenter.getWin(cid + "");
            }
        });
    }

    @Override
    public void showFeiShop(final FLrightBean fLrightBean, String cid) {
        final List<FLrightBean.DataBean> list = fLrightBean.getData();
        for (int i = 0; i < list.size(); i++) {
            Log.e("xddd", list.get(i).getName());
            rightadpter = new Rightadpter(getContext(), list);
            rlv3.setAdapter(rightadpter);
        }
        rightadpter.setonclick(new Rightadpter.Onclickitem() {
            @Override
            public void onClickitem(int pscid) {
                Intent intent = new Intent(getActivity(), SpflActivity.class);
                intent.putExtra("pscid",pscid);
                startActivity(intent);
            }
        });

    }


}
