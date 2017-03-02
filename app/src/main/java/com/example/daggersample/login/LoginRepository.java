package com.example.daggersample.login;

/**
 * Created by Admin on 03/02/17.
 */

public class LoginRepository implements LoginSource {
    private boolean isHasNetwork = false;

    private LoginRepository() {

    }

    public static LoginRepository makeLoginRepository() {
        return new LoginRepository();
    }

    @Override
    public void onLogin(User user, LoginCallBack callBack) {
        if (isHasNetwork) {
            callBack.onSuccess();
        } else {
            callBack.onFail();
        }
    }
}
