package com.example.daggersample.post;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;

import com.example.daggersample.Injection;
import com.example.daggersample.R;
import com.example.daggersample.login.LoginFragment;

/**
 * Created by Admin on 03/02/17.
 */

public class PostActivity extends AppCompatActivity {
    private PostPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostFragment fragment = (PostFragment) getSupportFragmentManager().findFragmentById(R.id.content_layout);

        if (fragment == null) {
            fragment = PostFragment.makeInstance();
            addFragmentToActivity(fragment);
        }

        mPresenter = new PostPresenter(Injection.providePostRepository(), fragment);
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
