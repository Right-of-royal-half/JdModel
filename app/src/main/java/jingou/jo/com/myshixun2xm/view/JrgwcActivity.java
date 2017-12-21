package jingou.jo.com.myshixun2xm.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jingou.jo.com.myshixun2xm.Bean.JrGwcbean;
import jingou.jo.com.myshixun2xm.R;
import jingou.jo.com.myshixun2xm.presenter.Jrgwpresenter;
import jingou.jo.com.myshixun2xm.view.connector.IJrgwcActivity;

public class JrgwcActivity extends AppCompatActivity implements IJrgwcActivity {

    private Jrgwpresenter jrgwpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jrgwc);
        /*jrgwpresenter = new Jrgwpresenter(this);
        jrgwpresenter.getgw();*/

    }

    @Override
    public void showxq(JrGwcbean jrGwcbean, String pid, String uid) {
        jrgwpresenter.getgw(pid,uid);
    }
}
