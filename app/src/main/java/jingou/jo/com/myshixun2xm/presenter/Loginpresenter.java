package jingou.jo.com.myshixun2xm.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jingou.jo.com.myshixun2xm.Bean.LoginBean;
import jingou.jo.com.myshixun2xm.model.connector.IloginMOdel;
import jingou.jo.com.myshixun2xm.model.loginMOdel;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.ILoginMainActivity;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class Loginpresenter {
  final ILoginMainActivity iLoginMainActivity;
    IloginMOdel iloginMOdel;
    public Loginpresenter(ILoginMainActivity iLoginMainActivity) {
        this.iLoginMainActivity = iLoginMainActivity;
        iloginMOdel=new loginMOdel();
    }
    public void getlogin(){
        String phone = iLoginMainActivity.getPhone();
        String pwd = iLoginMainActivity.getPwd();
        if(checkAccount(phone) && checkPwd(pwd)){
             //去调用model，进行登陆
            iloginMOdel.login(phone, pwd, new NetWorkListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                     iLoginMainActivity.show(loginBean);
                }

                @Override
                public void onFailed(Exception e) {

                }
            });
        }
    }

    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
           // iLoginMainActivity.show("请输入密码");
            return false;
        }
        if (pwd.length() <6) {
          //  iLoginMainActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }

    private boolean checkAccount(String phone) {
        if (TextUtils.isEmpty(phone)) {
            //给用户提示，输入的账号不能为空
            //iLoginMainActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(phone)) {
           // iLoginMainActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }
    /*
   判断是否是手机号
    */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public void register() {
        //其实就是跳转到注册页面
        iLoginMainActivity.toRegisterAc();
    }
}
