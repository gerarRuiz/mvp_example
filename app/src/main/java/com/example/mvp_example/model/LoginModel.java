package com.example.mvp_example.model;

import android.util.Log;

import com.example.mvp_example.interfaces.LoginMVP;

public class LoginModel {

    private static final String TAG = "Model";
    private static LoginMVP.Model instance;
    public static LoginMVP.Presenter presenter;

    public static LoginMVP.Model getInstance() {

        if (instance == null) {

            instance = new LoginMVP.Model() {
                @Override
                public void setPresenter(LoginMVP.Presenter presenter) {
                    LoginModel.presenter = presenter;
                }

                @Override
                public void doLogin(String user, String password) {
                    Log.i(TAG, "doLogin: " + user + " " + password);

                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    LoginModel.presenter.onResponse("Desde el model");
                }
            };

        }

        return instance;
    }


}
