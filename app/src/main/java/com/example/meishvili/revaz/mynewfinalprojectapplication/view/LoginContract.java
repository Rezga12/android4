package com.example.meishvili.revaz.mynewfinalprojectapplication.view;

import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;

public interface LoginContract {

    interface LoginView{

        void onLoginSuccess(Login login);
        void onLoginFailure();
        void onWrongInput();

    }

    interface LoginPresenter{
        void getLoginInformation(String username, String password);


    }

    interface LoginIntractor{

        interface OnFinishedListener{
            void onFinished(Login login);
            void onFailure(Throwable t);
        }

        void getLoginInformation(OnFinishedListener onFinishedListener, String username, String password);

    }



}
