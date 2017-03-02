package com.example.daggersample.login;

/**
 * Created by Admin on 03/02/17.
 */

public class Injection {
    public static LoginRepository provideLoginRepository() {
        return LoginRepository.makeLoginRepository();
    }
}
