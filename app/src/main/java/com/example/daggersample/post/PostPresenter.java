package com.example.daggersample.post;

import java.util.List;

/**
 * Created by Admin on 03/02/17.
 */

public class PostPresenter implements PostContract.Presenter {
    private PostContract.View view;
    private PostRepository mRepository;
    private boolean firstLoad = true;

    public PostPresenter(PostRepository repository, PostContract.View view) {
        this.view = view;
        mRepository = repository;
        view.setPresenter(this);
    }

    @Override
    public void loadPosts(boolean forceUpdate) {
        loadPosts(forceUpdate || firstLoad, true);
        firstLoad = false;
    }

    @Override
    public void onStart() {
        loadPosts(true);
    }

    private void loadPosts(boolean forceUpdate, final boolean showUIBar) {
        if (showUIBar) {
            view.showProgress();
        }
        if (forceUpdate) {
            mRepository.refreshData();
        }

        mRepository.getPosts(new PostDataSource.CallBack() {
            @Override
            public void onSuccess(List<Post> posts) {
                if (showUIBar) {
                    view.hideProgress();
                }
                view.showPosts(posts);
            }

            @Override
            public void onFail(Throwable t) {
                if (showUIBar) {
                    view.hideProgress();
                }

            }
        });
    }
}
