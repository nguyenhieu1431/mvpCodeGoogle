package com.example.daggersample.post;

/**
 * Created by Admin on 03/02/17.
 */

public interface PostContract {
    interface View {
        void showProgress();

        void hideProgress();

        void showPosts();

        void noPost();

        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void loadPosts();
    }
}
