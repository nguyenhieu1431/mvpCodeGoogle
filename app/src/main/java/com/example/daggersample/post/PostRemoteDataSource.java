package com.example.daggersample.post;

/**
 * Created by Admin on 03/02/17.
 */

public class PostRemoteDataSource implements PostDataSource {
    private static PostRemoteDataSource INSTANCE;

    public static PostRemoteDataSource makeInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PostRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getPosts(CallBack callBack) {

    }
}
