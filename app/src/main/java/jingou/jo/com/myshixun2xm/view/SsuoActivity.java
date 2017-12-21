package jingou.jo.com.myshixun2xm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import jingou.jo.com.myshixun2xm.Bean.SpSouSbean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.SousuoAdpter;
import jingou.jo.com.myshixun2xm.presenter.SpSsPresenter;
import jingou.jo.com.myshixun2xm.view.connector.ISsuoActivity;

public class SsuoActivity extends AppCompatActivity implements ISsuoActivity {

    private RecyclerView mRlv;
    private String name;
    private SpSsPresenter spSsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssuo);
        initView();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        spSsPresenter = new SpSsPresenter(this);
        spSsPresenter.getWin(name);
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showxq(SpSouSbean spSouSbean) {
        SousuoAdpter sousuoAdpter = new SousuoAdpter(SsuoActivity.this, spSouSbean.getData());
        mRlv.setAdapter(sousuoAdpter);
    }
}
