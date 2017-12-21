package jingou.jo.com.myshixun2xm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.view.PersonalActivity;

/**
 * Created by 杨杰 on 2017/10/25.
 */

public class Fragment05 extends Fragment{

    private View view;
    private LinearLayout ll_tx;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment5, container, false);
        initView();
        return view;
    }

    private void initView() {
        ll_tx = view.findViewById(R.id.ll);
        ll_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
            }
        });
    }
}
