package com.example.daggersample.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.daggersample.Injection;
import com.example.daggersample.R;


/**
 * Created by Admin on 03/02/17.
 */

public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.content_layout);

        if (fragment==null){
            fragment = LoginFragment.makeInstance();
            addFragmentToActivity(fragment);
        }


        mPresenter = new LoginPresenter(Injection.provideLoginRepository(), fragment);
    }


    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Login");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Log.i("", "");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addFragmentToActivity(@NonNull Fragment fragment) {
        addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.content_layout);
    }

    public void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                      @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }


}
