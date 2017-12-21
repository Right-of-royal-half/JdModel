package jingou.jo.com.myshixun2xm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.acker.simplezxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.Bean.SgouyeBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.Banneradpter;
import jingou.jo.com.myshixun2xm.adpter.Miaoshaadpter;
import jingou.jo.com.myshixun2xm.presenter.FLleftpresenter;
import jingou.jo.com.myshixun2xm.presenter.ShouYepresenter;
import jingou.jo.com.myshixun2xm.view.ChaxunActivity;
import jingou.jo.com.myshixun2xm.view.SpXqActivity;
import jingou.jo.com.myshixun2xm.view.connector.Ifragment2;
import jingou.jo.com.myshixun2xm.view.connector.Ishouyefragment1;

/**
 * Created by 杨杰 on 2017/10/25.
 */

public class Fragment01 extends Fragment implements Ishouyefragment1, Ifragment2{
    private List<String> list = new ArrayList<>();
    private List<Fragment> flist;
    private fragmet01_item1 fragmet01_item1;
    private fragmet01_item2 fragmet01_item2;
    private ViewPager vip;
    private Banner banner;
    private View view;
    private ShouYepresenter shouYepresenter;
    private FLleftpresenter lleftpresenter;
    private RecyclerView rlv_xq;
    private RecyclerView miao_rlv;
    private ImageView saomiao;
    private EditText cz;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment1, container, false);
        //扫描
        saomiao = view.findViewById(R.id.saomiao);
        saomiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), CaptureActivity.REQ_CODE);
            }
        });
        //查找
        cz = view.findViewById(R.id.et_cz);
        cz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(getActivity(), ChaxunActivity.class));
            }
        });
        ShouYepresenter shouYepresenter = new ShouYepresenter(this);
        vip = view.findViewById(R.id.vip);
        flist = new ArrayList<>();
        fragmet01_item1 = new fragmet01_item1();
        fragmet01_item2 = new fragmet01_item2();
        flist.add(fragmet01_item1);
        flist.add(fragmet01_item2);
        shouYepresenter.Win();
        lleftpresenter = new FLleftpresenter(this);
        lleftpresenter.getflleft();
        tuijian();
        miaoshajd();
        return view;
    }
//秒杀
    private void miaoshajd() {
        miao_rlv = view.findViewById(R.id.miao_rlv);
        miao_rlv.setLayoutManager(new GridLayoutManager(getActivity(),20));
    }

    //推荐
    private void tuijian() {
        rlv_xq = view.findViewById(R.id.rlv);
        rlv_xq.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void show(SgouyeBean sgouyeBean) {
        tuijianff(sgouyeBean);
        miaosha(sgouyeBean);
        banner = view.findViewById(R.id.banner);
        for (int i = 0; i < sgouyeBean.getData().size(); i++) {
            String icon = sgouyeBean.getData().get(i).getIcon();
            list.add(icon);
        }
        banner.setImages(list);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setDelayTime(2000);
//启动banner
        banner.start();
    }

    //秒杀
    private void miaosha(SgouyeBean sgouyeBean) {
        SgouyeBean.MiaoshaBean miaosha = sgouyeBean.getMiaosha();
        Miaoshaadpter miaoshaadpter = new Miaoshaadpter(getActivity(), miaosha.getList());
        miao_rlv.setAdapter(miaoshaadpter);
        miaoshaadpter.setMiaoshaadpter(new Miaoshaadpter.OnClickms() {
            @Override
            public void onClickms(int position) {
                Intent intent = new Intent(getActivity(), SpXqActivity.class);
                intent.putExtra("pid", position);
                startActivity(intent);
            }
        });
    }

    private void tuijianff(SgouyeBean sgouyeBean) {
        SgouyeBean.TuijianBean tuijian = sgouyeBean.getTuijian();
        Banneradpter banneradpter = new Banneradpter(tuijian.getList(), getActivity());
        rlv_xq.setAdapter(banneradpter);
  /*      banneradpter.setOnclickSpflAdpter(new SpflAdpter.OnClickfl() {
            @Override
            public void onClickxq(int pid) {
                Intent intent = new Intent(getActivity(), SpXqActivity.class);
                intent.putExtra("pid", pid);
                startActivity(intent);
            }
        });*/
       banneradpter.setOnclickSpflAdpter(new Banneradpter.OnClickfl() {
           @Override
           public void onClickxq(int position) {
               Intent intent = new Intent(getActivity(), SpXqActivity.class);
               intent.putExtra("pid", position);
               startActivity(intent);
           }
       });

    }

    @Override
    public void show(FlleftBean flleftBean) {
        vip.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return flist.get(position);
            }

            @Override
            public int getCount() {
                return flist.size();
            }
        });
    }

    @Override
    public void showFeiShop(FLrightBean fLrightBean, String cid) {

    }
}

