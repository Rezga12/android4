package com.example.meishvili.revaz.mynewfinalprojectapplication;

import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;
import com.example.meishvili.revaz.mynewfinalprojectapplication.view.LoginContract;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {


    private LoginContract.LoginIntractor intractor;
    private LoginContract.LoginView view;

    public LoginPresenterImpl(LoginContract.LoginIntractor intractor, LoginContract.LoginView view){
        this.intractor = intractor;
        this.view = view;
    }

    @Override
    public void getLoginInformation(String username, String password) {

        if(!(password.length() < 20 && password.length() > 3) || !(username.length() < 20 && username.length() > 3)){
            view.onWrongInput();
            return;
        }


        LoginContract.LoginIntractor.OnFinishedListener listener = new LoginContract.LoginIntractor.OnFinishedListener() {
            @Override
            public void onFinished(Login login) {
                if(view != null){
                    view.onLoginSuccess(login);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        };

        intractor.getLoginInformation(listener,username,password);


    }
}
