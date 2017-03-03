package com.example.daggersample.post;

import java.util.List;

/**
 * Created by Admin on 03/02/17.
 */

public interface PostDataSource {
    interface CallBack {
        void onSuccess(List<Post> posts);

        void onFail(Throwable t);
    }

    void getPosts(CallBack callBack);
}
