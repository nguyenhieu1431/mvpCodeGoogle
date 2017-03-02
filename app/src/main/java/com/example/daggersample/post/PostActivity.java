package com.example.daggersample.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;

import com.example.daggersample.R;

/**
 * Created by Admin on 03/02/17.
 */

public class PostActivity extends AppCompatActivity {
    private PostPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new PostPresenter();
    }
}
