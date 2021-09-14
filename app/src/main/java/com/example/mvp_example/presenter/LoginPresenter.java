package com.example.mvp_example.presenter;

import android.util.Log;

import com.example.mvp_example.interfaces.LoginMVP;
import com.example.mvp_example.model.LoginModel;

public class LoginPresenter implements LoginMVP.Presenter {

    private static final String TAG = "Presenter";
    private LoginMVP.View view;
    private LoginMVP.Model model;

    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
    }

    private LoginMVP.Model getModelInstance() {
        if (model == null) {
            model = new LoginModel(this);
        }
        return model;
    }

    @Override
    public void executeLogin(String user, String password) {
        view.showinProgressBar(true);
        view.showinButtonLogin(false);
        getModelInstance().doLogin(user, password);
    }

    @Override
    public void onResponse(String response) {
        view.showinProgressBar(true);
        view.showinButtonLogin(false);
        Log.i(TAG, "onResponse: " + response);
    }

}
