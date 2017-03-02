package com.example.daggersample.post;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 03/02/17.
 */

public class PostRepository implements PostDataSource {
    private static PostRepository INSTANCE;
    private PostDataSource mPostRemoteDataSource;
    private PostDataSource mPostLocalDataSource;

    private PostRepository(PostDataSource postRemoteDataSource, PostDataSource postLocalDataSource) {
        mPostRemoteDataSource = checkNotNull(postRemoteDataSource);
        mPostLocalDataSource = checkNotNull(postLocalDataSource);
    }

    public static PostRepository makeInstance(PostDataSource postRemoteDataSource, PostDataSource postLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new PostRepository(postRemoteDataSource, postLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getPosts() {

    }
}
