package com.unittestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.unittestdemo.base.BaseEditText;
import com.unittestdemo.utils.Validator;


public class LoginActivity extends AppCompatActivity {
    private BaseEditText mEdtEmail;
    private BaseEditText mEdtPwd;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        mEdtEmail = findViewById(R.id.edt_email);
        mEdtPwd = findViewById(R.id.edt_pwd);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if (mEdtEmail.isEmpty() && mEdtPwd.isEmpty()) {
            mEdtEmail.setError("Enter Email");
            mEdtPwd.setError("Enter Password");
        } else if (mEdtEmail.isEmpty()) {
            mEdtEmail.setError("Enter Email");
        } else if (!mEdtEmail.isEmpty() && !Validator.isEmailValid(mEdtEmail.getText().toString().trim())) {
            mEdtEmail.setError("Enter valid email");
        } else if (mEdtPwd.isEmpty()) {
            mEdtPwd.setError("Enter Password");
        } else if (!mEdtPwd.isEmpty() && !Validator.isPasswordValid(mEdtPwd.getText().toString().trim())) {
            mEdtPwd.setError("Enter password in between 6 - 30");
        } else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}