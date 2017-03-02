package com.example.daggersample.post;

/**
 * Created by Admin on 03/02/17.
 */

public class PostPresenter implements PostContract.Presenter {
    private PostContract.View view;
    private PostRepository mRepository;

    public PostPresenter(PostRepository repository, PostContract.View view) {
        this.view = view;
        mRepository = repository;
        view.setPresenter(this);
    }

    @Override
    public void loadPosts() {
        mRepository.getPosts();
    }
}
