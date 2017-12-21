package jingou.jo.com.myshixun2xm.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import jingou.jo.com.myshixun2xm.Bean.LoginBean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.presenter.Loginpresenter;
import jingou.jo.com.myshixun2xm.view.connector.ILoginMainActivity;

public class PersonalActivity extends AppCompatActivity implements ILoginMainActivity, View.OnClickListener {
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1106390759";//官方获取的APPID
    private ImageView mTc;
    /**
     * 请输入账号
     */
    private EditText mEtNum;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登录
     */
    private Button mBt;
    /**
     * 注册
     */
    private TextView mTvZc;
    /**
     * 登录
     */
    private ImageView mWx;
    private ImageView mQq;
    private BaseUiListener mIUiListener;
    /**
     * 忘记密码
     */
    private TextView mWj;
    private Loginpresenter loginpresenter;
    private Tencent tencent;
    private UserInfo mUserInfo;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        //创建SharedPreferences对象
        sharedPreferences=getSharedPreferences("user",0);
        //传入参数APPID和全局Context上下文
        tencent = Tencent.createInstance(APP_ID, PersonalActivity.this.getApplicationContext());
        initView();
        loginpresenter = new Loginpresenter(this);

    }

    private void initView() {
        mTc = (ImageView) findViewById(R.id.tc);
        mEtNum = (EditText) findViewById(R.id.et_num);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mTvZc = (TextView) findViewById(R.id.tv_zc);
        mWx = (ImageView) findViewById(R.id.wx);
        mQq = (ImageView) findViewById(R.id.qq);
        mQq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 mIUiListener = new BaseUiListener();
                 tencent.login(PersonalActivity.this, "all", mIUiListener);
                 Toast.makeText(PersonalActivity.this,"adsfafs",Toast.LENGTH_SHORT).show();
            }
        });
        mTc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //跳转注册页面
        mTvZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, ZcActivity.class);
                startActivity(intent);
            }
        });
        mWj = (TextView) findViewById(R.id.wj);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                loginpresenter.getlogin();
                break;
        }
    }

    //获取手机号
    @Override
    public String getPhone() {
        return mEtNum.getText().toString().trim();
    }

    //获取密码
    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    //展示
    @Override
    public void show(LoginBean loginBean) {
        Toast.makeText(PersonalActivity.this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        if(loginBean.getMsg().equals("登录成功"))
        {
            Intent intent=new Intent(PersonalActivity.this,MainActivity.class);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("uid",loginBean.getData().getUid()+"");
            editor.commit();
            startActivity(intent);
        }
    }

    //跳转
    @Override
    public void toRegisterAc() {
        Intent intent = new Intent(PersonalActivity.this, ZcActivity.class);
        startActivity(intent);
    }

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(PersonalActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                tencent.setOpenId(openID);
                tencent.setAccessToken(accessToken, expires);
                QQToken qqToken = tencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG, "登录成功" + response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(PersonalActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(PersonalActivity.this, "授权取消", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}