package com.pym.littlemvp.login.Presenter;

import android.text.TextUtils;

import com.pym.littlemvp.login.interfaces.ILogin;
import com.pym.littlemvp.login.interfaces.ILoginPresenter;
import com.pym.littlemvp.login.model.LoginModel;

/**
 * Created by Administrator on 2017/3/8.
 */

public class LoginPresenter implements ILoginPresenter, LoginModel.LoginFinish {
    private ILogin iLogin;

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    @Override
    public void login(String userName, String pwd) {
        if (TextUtils.isEmpty(userName)) {
            iLogin.showTips("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            iLogin.showTips("请输入密码");
            return;
        }
        LoginModel.getIntence().login(userName,pwd,this);
        iLogin.showProgress();
    }

    @Override
    public void success() {
        iLogin.hideProgress();
        iLogin.showTips("成功");
    }

    @Override
    public void failure() {
        iLogin.hideProgress();
        iLogin.showTips("失败");
    }
}
