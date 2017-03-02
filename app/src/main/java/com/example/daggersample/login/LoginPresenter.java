package com.example.daggersample.login;

import android.util.Log;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by Admin on 03/02/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    protected LoginContract.View mView;
    private LoginRepository mRepository;

    public LoginPresenter(LoginRepository repository, LoginContract.View view) {
        mView = view;
        mRepository = repository;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        Log.i("", "");
    }

    @Override
    public void stop() {

    }

    @Override
    public void onLogin(User user) {
        checkNotNull(mRepository);
        mView.showProgress();
        mRepository.onLogin(user, new LoginSource.LoginCallBack() {
            @Override
            public void onSuccess() {
                mView.hideProgress();
                mView.onLoginSuccess();
            }

            @Override
            public void onFail() {
                mView.hideProgress();
                mView.onLoginFail();
            }
        });
    }
}
