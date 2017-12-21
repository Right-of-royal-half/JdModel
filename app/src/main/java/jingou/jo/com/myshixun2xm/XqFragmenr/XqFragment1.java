package jingou.jo.com.myshixun2xm.XqFragmenr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.Spxqadpter;
import jingou.jo.com.myshixun2xm.fragment.GlideImageLoader;
import jingou.jo.com.myshixun2xm.presenter.Jrgwpresenter;
import jingou.jo.com.myshixun2xm.presenter.SpXQpresenter;
import jingou.jo.com.myshixun2xm.view.connector.Ixqfeagment;

/**
 * Created by 杨杰 on 2017/12/18.
 */

public class XqFragment1 extends Fragment implements Ixqfeagment {
    private List<String> list = new ArrayList<>();
    private Banner banner;
    private RecyclerView rlv;
    private View view;
   SharedPreferences sharedPreferences;
   Jrgwpresenter jrgwpresenter;
   String uid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.xq_item1, null);
        rlv = view.findViewById(R.id.rlv_xq);
        //创建SharedPreferences对象
        sharedPreferences=getActivity().getSharedPreferences("user",0);
        uid=sharedPreferences.getString("uid","0");
        //实例加入购物车的P层
        jrgwpresenter=new Jrgwpresenter(this);
        /*view.findViewById(R.id.)*/
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Intent intent = getActivity().getIntent();
        int pid = intent.getIntExtra("pid",0);
        SpXQpresenter spXQpresenter = new SpXQpresenter(this);
        spXQpresenter.getwin(pid+"");
        return view;
    }

    @Override
    public void showxq(SPxiangqingBean sPxiangqingBean, String pid) {
        Spxqadpter spxqadpter = new Spxqadpter(getActivity(),sPxiangqingBean.getData());
        rlv.setAdapter(spxqadpter);
        banner = view.findViewById(R.id.banner);
            String icon[] = sPxiangqingBean.getData().getImages().split("\\|");
            for(int i=0;i<icon.length;i++)
            {
                list.add(icon[i]);
            }
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setImages(list);
        banner.setDelayTime(5000000);
//启动banner
        banner.start();

        spxqadpter.setOnAddCar(new Spxqadpter.OnAddCar() {
            @Override
            public void addCar(int pid) {
                 jrgwpresenter.getgw(pid+"",uid);
            }
        });
    }

    @Override
    public void showAddCar(JrGwcbean jrGwcbean) {
        Toast.makeText(getActivity(),jrGwcbean.getMsg(),Toast.LENGTH_SHORT).show();
    }

}
