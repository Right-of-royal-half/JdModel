package jingou.jo.com.myshixun2xm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import jingou.jo.com.myshixun2xm.R;

public class ChaxunActivity extends AppCompatActivity {

    private ImageView mTh;
    private EditText mEtCz;
    /**
     * 搜索
     */
    private TextView mTvSousuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);
        initView();
    }

    private void initView() {
        mTh = (ImageView) findViewById(R.id.th);
        mEtCz = (EditText) findViewById(R.id.et_cz);
        mTvSousuo = (TextView) findViewById(R.id.tv_sousuo);
        mTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEtCz.getText().toString().trim();
                Intent intent = new Intent(ChaxunActivity.this, SsuoActivity.class);
                intent.putExtra("name",s);
                startActivity(intent);
            }
        });
    }
}
