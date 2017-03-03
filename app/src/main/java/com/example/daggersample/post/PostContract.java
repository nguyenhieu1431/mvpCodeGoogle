package com.example.daggersample.post;

import java.util.List;

/**
 * Created by Admin on 03/02/17.
 */

public interface PostContract {
    interface View {
        void showProgress();

        void hideProgress();

        void showPosts(List<Post> posts);

        void noPost();

        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void loadPosts(boolean forceUpdate);
        void onStart();
    }
}
