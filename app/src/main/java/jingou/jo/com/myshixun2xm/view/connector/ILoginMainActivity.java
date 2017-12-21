package jingou.jo.com.myshixun2xm.view.connector;

import jingou.jo.com.myshixun2xm.Bean.LoginBean;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public interface ILoginMainActivity {
    //获取手机号
    public String getPhone();

    //获取密码
    public String getPwd();

    //显示登陆成功后的数据
    public void show(LoginBean str);
    //跳转
    public void toRegisterAc();
}
