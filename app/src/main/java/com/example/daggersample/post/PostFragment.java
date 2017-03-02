package com.example.daggersample.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daggersample.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 03/02/17.
 */

public class PostFragment extends Fragment implements PostContract.View {
    private PostContract.Presenter mPresenter;

    public static PostFragment makeInstance() {
        return new PostFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadPosts();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showPosts() {

    }

    @Override
    public void noPost() {

    }

    @Override
    public void setPresenter(PostContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
