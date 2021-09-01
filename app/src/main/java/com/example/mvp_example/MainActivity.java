package com.example.mvp_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mvp_example.databinding.ActivityMainBinding;
import com.example.mvp_example.interfaces.LoginMVP;
import com.example.mvp_example.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginMVP.View {

    private static final String TAG = "View";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LoginPresenter.getPresenter().setView(this);

        binding.btnLogin.setOnClickListener(v -> LoginPresenter.getPresenter().executeLogin("Hola", "Mundo"));

    }

    @Override
    public void showinProgressBar(boolean isShowing) {
        Log.i(TAG, "showinProgressBar: " + isShowing);
        binding.progressBar.setVisibility(!isShowing ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showinButtonLogin(boolean isShowing) {
        binding.btnLogin.setVisibility(!isShowing ? View.VISIBLE : View.GONE);
    }
}