package com.example.daggersample.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.daggersample.R;
import com.example.daggersample.post.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 03/02/17.
 */

public class PostFragment extends Fragment implements PostContract.View {
    private PostContract.Presenter mPresenter;
    private RecyclerView mPostRc;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar mLoadMoreBar;
    private PostAdapter mAdapter;
    private List<Post> mPost = new ArrayList<>();

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
        mPostRc = (RecyclerView) view.findViewById(R.id.post_rc);
        mLoadMoreBar = (ProgressBar) view.findViewById(R.id.load_more);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_group);

        mAdapter = new PostAdapter();
        mAdapter.setData(mPost);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mPostRc.setLayoutManager(manager);
        mPostRc.setAdapter(mAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.clear();
                mPresenter.loadPosts(true);
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onStart();
    }

    @Override
    public void showProgress() {
        mLoadMoreBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadMoreBar.setVisibility(View.GONE);
    }

    @Override
    public void showPosts(List<Post> posts) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.addAll(posts);
    }


    @Override
    public void noPost() {

    }

    @Override
    public void setPresenter(PostContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
