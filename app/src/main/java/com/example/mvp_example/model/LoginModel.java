package com.example.mvp_example.model;

import android.util.Log;

import com.example.mvp_example.interfaces.LoginMVP;

public class LoginModel implements LoginMVP.Model {

    private static final String TAG = "Model";
    private LoginMVP.Presenter presenter;

    public LoginModel(LoginMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void doLogin(String user, String password) {

        Log.i(TAG, "doLogin: " + user + " " + password);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        presenter.onResponse("Desde el model");

    }

}
