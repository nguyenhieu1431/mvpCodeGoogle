package com.example.daggersample.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daggersample.R;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by Admin on 03/02/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View {
    protected LoginContract.Presenter mPresenter;
    private EditText mNameEdt, mPassEdt;
    private Button mLoginBtn;
    private ProgressBar mLoadingProgress;

    public static LoginFragment makeInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNameEdt = (EditText) view.findViewById(R.id.name_edt);
        mPassEdt = (EditText) view.findViewById(R.id.pass_edt);
        mLoginBtn = (Button) view.findViewById(R.id.login_btn);
        mLoadingProgress = (ProgressBar) view.findViewById(R.id.progress_bar);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onLogin(new User(mNameEdt.getText().toString(), mPassEdt.getText().toString()));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(LoginContract.Presenter p) {
        mPresenter = p;
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(getActivity(), "Login Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mLoadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingProgress.setVisibility(View.GONE);
    }
}
