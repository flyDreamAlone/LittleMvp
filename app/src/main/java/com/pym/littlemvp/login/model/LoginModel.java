package com.pym.littlemvp.login.model;

/**
 * Created by Administrator on 2017/3/8.
 */

public class LoginModel {
    public static LoginModel getIntence() {
        return new LoginModel();
    }

    public void login(String userName, String pwd, LoginFinish loginFinish) {
        if (userName.equals(pwd)){
            loginFinish.failure();
        }else{
            loginFinish.failure();
        }
    }

    public interface LoginFinish {
        public abstract void success();

        public abstract void failure();
    }
}
