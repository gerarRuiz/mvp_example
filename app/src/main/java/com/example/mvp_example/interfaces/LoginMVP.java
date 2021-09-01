package com.example.mvp_example.interfaces;

public interface LoginMVP {

    interface View{

        void showinProgressBar(boolean isShowing);
        void showinButtonLogin(boolean isShowing);

    }

    interface Presenter{

        void setView(LoginMVP.View view);
        void executeLogin(String user, String password);
        void onResponse(String response);


    }

    interface Model {

        void setPresenter(LoginMVP.Presenter presenter);
        void doLogin(String user, String password);

    }

}
