package com.ais.mnc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ais.mnc.R;
import com.ais.mnc.bean.UserBean;
import com.ais.mnc.db.UserDBHelper;
import com.ais.mnc.util.MncUtilities;

public class UserSignUpActivity extends AppCompatActivity{

    Toolbar toolbar;
    EditText email,password,name;
    CheckBox checkBox;
    ImageButton signup;
    Button signin;

    UserDBHelper mUserDBHelper;
    UserBean signup_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);


        mUserDBHelper = new UserDBHelper(this);

        signup_user = new UserBean(
                name.getText().toString(),
                email.getText().toString(),
                password.getText().toString()
                );

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mUserDBHelper.doSignUp(signup_user)) {
                    MncUtilities.toastMessage(UserSignUpActivity.this, "Sign up done!");
                    MncUtilities.startNextActivity(UserSignUpActivity.this, UserLoginActivity.class, true);
                } else {
                    MncUtilities.toastMessage(UserSignUpActivity.this, "Sign up error!");
                }
                MncUtilities.toastMessage(UserSignUpActivity.this, "");
            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MncUtilities.startNextActivity(UserSignUpActivity.this, UserLoginActivity.class, true);
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        checkBox = findViewById(R.id.checkbox);

        signup =findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
    }
}