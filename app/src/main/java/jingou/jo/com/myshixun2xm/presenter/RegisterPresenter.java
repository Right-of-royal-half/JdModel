package jingou.jo.com.myshixun2xm.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jingou.jo.com.myshixun2xm.Bean.ZcBean;
import jingou.jo.com.myshixun2xm.model.connector.IRegister;
import jingou.jo.com.myshixun2xm.model.Register;
import jingou.jo.com.myshixun2xm.net.NetWorkListener;
import jingou.jo.com.myshixun2xm.view.connector.IZcActivity;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class RegisterPresenter {
    final IZcActivity iZcActivity;
    IRegister iRegister;
    public RegisterPresenter(IZcActivity iZcActivity) {
        this.iZcActivity = iZcActivity;
        iRegister=new Register();
    }
    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iZcActivity.show("请输入密码");
            return false;
        }

        if (pwd.length() <6) {
            iZcActivity.show("请输入6位以上密码");
            return false;
        }
        return true;
    }
    /**
     * 验证手机号是否正确
     *
     * @param account
     */
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iZcActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iZcActivity.show("请输入正确的手机号");
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
        String account = iZcActivity.getAccount();
        String pwd = iZcActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            iRegister.register(account, pwd, new NetWorkListener<ZcBean>() {
                @Override
                public void onSuccess(ZcBean zcBean) {
                    //成功以后，回到登陆界面
                    if (zcBean.getCode().equals("1")) {
                        iZcActivity.show(zcBean.getMsg());
                    } else {
                        iZcActivity.show(zcBean.getMsg());
                        iZcActivity.finishAc();
                    }
                }

                @Override
                public void onFailed(Exception e) {

                }
            });
        }
    }
}
