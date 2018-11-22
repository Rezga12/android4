package com.example.meishvili.revaz.mynewfinalprojectapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meishvili.revaz.mynewfinalprojectapplication.LoginPresenterImpl;
import com.example.meishvili.revaz.mynewfinalprojectapplication.main.MainActivity;
import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.LoginIntractorImpl;

public class LoginActivity extends AppCompatActivity  implements LoginContract.LoginView{
    private EditText userText;
    private EditText passText;
    private Button loginButton;

    private LoginContract.LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userText = findViewById(R.id.loginField);
        passText = findViewById(R.id.passField);

        loginButton = findViewById(R.id.loginButton);

        presenter = new LoginPresenterImpl(new LoginIntractorImpl(),this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.getLoginInformation(userText.getText().toString(),passText.getText().toString());
            }
        });

    }


    @Override
    public void onLoginSuccess(Login login) {
        Toast.makeText(this, login.getSessionId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("id",login.getSessionId());
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure() {

    }

    @Override
    public void onWrongInput() {
        Toast.makeText(this, R.string.on_wrong_input, Toast.LENGTH_SHORT).show();
    }
}
