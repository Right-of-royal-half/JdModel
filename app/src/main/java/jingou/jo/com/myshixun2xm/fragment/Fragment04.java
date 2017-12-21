package jingou.jo.com.myshixun2xm.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.MessageEvent;
import jingou.jo.com.myshixun2xm.PriceCountEvent;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.CxgwcAdpter;
import jingou.jo.com.myshixun2xm.presenter.CxgwPresenter;
import jingou.jo.com.myshixun2xm.view.connector.ICxgwActivity;

/**
 * Created by 杨杰 on 2017/10/25.
 */

public class Fragment04 extends Fragment implements ICxgwActivity {
    private ExpandableListView elv;
    private CheckBox cb;
    private TextView count;
    private TextView tv_price;
    private List<List<CxgwcBean.DataBean.ListBean>> cbl;
    private CxgwcAdpter myadpter;
    private View view;
    SharedPreferences sharedPreferences;
    String uid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment4, container, false);
        EventBus.getDefault().register(this);
        initView();
        sharedPreferences=getActivity().getSharedPreferences("user",0);
        uid=sharedPreferences.getString("uid",0+"");
        new CxgwPresenter(this).getWincx(uid);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myadpter.changeAllListState(cb.isChecked());
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        elv = (ExpandableListView) view.findViewById(R.id.elv);
        cb = (CheckBox) view.findViewById(R.id.cb);
        count = (TextView) view.findViewById(R.id.tv_count);
        tv_price = (TextView) view.findViewById(R.id.tv_price);
    }





    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        cb.setChecked(event.isChecked());
    }

    ;

    @Subscribe
    public void onMessageEvent(PriceCountEvent event) {
        count.setText("总计：" + event.getCount() + "");
        tv_price.setText("结算(" + event.getPrice() + ")");
    }


    @Override
    public void showList(List<CxgwcBean.DataBean> grouplist, List<List<CxgwcBean.DataBean.ListBean>> childlist, String uid) {
        myadpter = new CxgwcAdpter(grouplist, childlist, getActivity());
        elv.setAdapter(myadpter);
        elv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < grouplist.size(); i++) {
            elv.expandGroup(i);
        }
    }
}
