package com.example.meishvili.revaz.mynewfinalprojectapplication.network;

import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;
import com.example.meishvili.revaz.mynewfinalprojectapplication.view.LoginContract;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;

public class LoginIntractorImpl implements LoginContract.LoginIntractor {
    @Override
    public void getLoginInformation(final OnFinishedListener onFinishedListener, String username, String password) {
        Api api = RetrofitInstance.getRetrofitInstance().create(Api.class);

        api.getLogin(username,password).enqueue(new retrofit2.Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    onFinishedListener.onFinished(response.body());
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });


    }
}
