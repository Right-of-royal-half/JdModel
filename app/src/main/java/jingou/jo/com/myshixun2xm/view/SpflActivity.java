package jingou.jo.com.myshixun2xm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.adpter.SpflAdpter;
import jingou.jo.com.myshixun2xm.presenter.SpflPresenter;
import jingou.jo.com.myshixun2xm.view.connector.ISpflActivity;

public class SpflActivity extends AppCompatActivity implements ISpflActivity {

    private ImageView mTh;
    private EditText mEtCz;
    /**
     * 搜索
     */
    private RecyclerView mSpflRlv;
    private int pscid;
    private ImageView imageView;
    private boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spfl2);
        initView();
        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid", 1);
        Log.d("pscid:", pscid + "");
        SpflPresenter spflPresenter = new SpflPresenter(this);
        spflPresenter.getWinsp(pscid + "");
        String sou=mEtCz.getText().toString().trim();
    }

    //接口实现
    @Override
    public void showFlzflbean(Flzflbean flzflbean, String pscid) {
        List<Flzflbean.DataBean> data = flzflbean.getData();
        SpflAdpter spflAdpter = new SpflAdpter(data, SpflActivity.this);
        mSpflRlv.setAdapter(spflAdpter);
        spflAdpter.setOnclickSpflAdpter(new SpflAdpter.OnClickfl() {
            @Override
            public void onClickxq(int pid) {
                Intent intent = new Intent(SpflActivity.this, SpXqActivity.class);
                intent.putExtra("pid", pid);
                startActivity(intent);
            }
        });
        Log.d("data:", data + "");

    }

    private void initView() {
        mTh = (ImageView) findViewById(R.id.th);
        mTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mEtCz = (EditText) findViewById(R.id.et_cz);
        imageView = (ImageView) findViewById(R.id.tv_zh);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SpflActivity.this, "点击了切换视图按钮", Toast.LENGTH_SHORT).show();
                if (b == false) {
//点击后想要变成什么要的布局样式就搞一个你的需求
                    mSpflRlv.setLayoutManager(new GridLayoutManager(SpflActivity.this, 2));
//给布尔值重新赋值
                    b = true;
//给点击按钮的图片重新赋值
                    /*im.setImageResource(R.mipmap.ic_linear);*/
                } else if (b == true) {
                    mSpflRlv.setLayoutManager(new LinearLayoutManager(SpflActivity.this));
//给布尔值重新赋值
                    b = false;
//给点击按钮的图片重新赋值
                 /*   cIv.setImageResource(R.mipmap.ic_grid);*/
                }
            }
        });
        mSpflRlv = (RecyclerView) findViewById(R.id.spfl_rlv);
        mSpflRlv.setLayoutManager(new LinearLayoutManager(this));
    }
}
