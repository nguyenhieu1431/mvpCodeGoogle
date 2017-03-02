package com.example.daggersample.login;

/**
 * Created by Admin on 03/02/17.
 */

public interface LoginSource {
    interface LoginCallBack {
        void onSuccess();

        void onFail();
    }

    void onLogin(User user, LoginCallBack callBack);
}
