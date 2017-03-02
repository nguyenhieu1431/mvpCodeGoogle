package com.example.daggersample;

import com.example.daggersample.login.LoginRepository;
import com.example.daggersample.post.PostLocalDataSource;
import com.example.daggersample.post.PostRemoteDataSource;
import com.example.daggersample.post.PostRepository;

/**
 * Created by Admin on 03/02/17.
 */

public class Injection {
    public static LoginRepository provideLoginRepository() {
        return LoginRepository.makeLoginRepository();
    }

    public static PostRepository providePostRepository() {
        return PostRepository.makeInstance(PostRemoteDataSource.makeInstance(), PostLocalDataSource.makeInstance());
    }
}
