package com.example.mvp_example.presenter;

import android.util.Log;

import com.example.mvp_example.interfaces.LoginMVP;
import com.example.mvp_example.model.LoginModel;

public class LoginPresenter {

    private static final String TAG = "Presenter";
    private static LoginMVP.Presenter instance;
    private static LoginMVP.View view;

    public static LoginMVP.Presenter getPresenter() {

        if (instance == null) {

            instance = new LoginMVP.Presenter() {

                @Override
                public void setView(LoginMVP.View view) {
                    LoginPresenter.view = view;
                }

                @Override
                public void executeLogin(String user, String password) {
                    LoginPresenter.view.showinProgressBar(true);
                    LoginPresenter.view.showinButtonLogin(false);
                    LoginModel.getInstance().setPresenter(this);
                    LoginModel.getInstance().doLogin(user, password);
                }

                @Override
                public void onResponse(String response) {
                    LoginPresenter.view.showinProgressBar(true);
                    LoginPresenter.view.showinButtonLogin(false);
                    Log.i(TAG, "onResponse: " + response);
                }
            };

        }

        return instance;
    }


}
