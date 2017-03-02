package com.example.daggersample.login;

/**
 * Created by Admin on 03/01/17.
 */

public interface LoginContract {
    interface View {
        void setPresenter(Presenter p);

        void onLoginSuccess();

        void onLoginFail();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void start();

        void stop();

        void onLogin(User user);
    }
}
