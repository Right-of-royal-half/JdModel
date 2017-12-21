package jingou.jo.com.myshixun2xm.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.presenter.RegisterPresenter;
import jingou.jo.com.myshixun2xm.view.connector.IZcActivity;

public class ZcActivity extends AppCompatActivity implements IZcActivity, View.OnClickListener {

    private ImageView mTc;
    /**
     * 请输入账号
     */
    private EditText mZcEtNum;
    /**
     * 请输入密码
     */
    private EditText mZcEtPwd;
    /**
     * 注册
     */
    private Button mBtZc;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        registerPresenter = new RegisterPresenter(this);
        initView();
    }


    private void initView() {
        mTc = (ImageView) findViewById(R.id.tc);
        mZcEtNum = (EditText) findViewById(R.id.zc_et_num);
        mZcEtPwd = (EditText) findViewById(R.id.zc_et_pwd);
        mBtZc = (Button) findViewById(R.id.bt_zc);
        mBtZc.setOnClickListener(this);
        mTc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_zc:
                registerPresenter.register();
                break;
        }
    }


    @Override
    public String getAccount() {
        return mZcEtNum.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mZcEtPwd.getText().toString().trim();
    }

    @Override
    public void finishAc() {
        finish();
    }

    @Override
    public void show(String str) {
        Toast.makeText(ZcActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
