package jingou.jo.com.myshixun2xm.view;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.fragment.Fragment01;
import jingou.jo.com.myshixun2xm.fragment.Fragment02;
import jingou.jo.com.myshixun2xm.fragment.Fragment03;
import jingou.jo.com.myshixun2xm.fragment.Fragment04;
import jingou.jo.com.myshixun2xm.fragment.Fragment05;

public class MainActivity extends AppCompatActivity {


    private BottomTabBar mBottomTabBar;
     SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //创建SharedPreferences对象
        sharedPreferences=getSharedPreferences("user",0);
        //拿到后返回的用户id

        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setFontSize(15)
                .setTabPadding(2, 5, 5)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.mipmap.shouye2, R.mipmap.shouye, Fragment01.class)
                .addTabItem("分类", R.mipmap.fenlei2, R.mipmap.fenlei, Fragment02.class)
                .addTabItem("发现", R.mipmap.faxian2, R.mipmap.faxian, Fragment03.class)
                .addTabItem("购物车", R.mipmap.gouwu2, R.mipmap.gouwu, Fragment04.class)
                .addTabItem("个人中心", R.mipmap.geren2, R.mipmap.geren, Fragment05.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(false);


    }

    private void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }
}
