package com.example.daggersample.post;

/**
 * Created by Admin on 03/02/17.
 */

public class PostLocalDataSource implements PostDataSource {
    private static PostLocalDataSource INSTANCE;

    public static PostLocalDataSource makeInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PostLocalDataSource();
        }
        return INSTANCE;
    }

    private void buildList() {

    }

    @Override
    public void getPosts(CallBack callBack) {

    }
}
