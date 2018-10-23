package com.ais.mnc.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.UserBean;
import com.ais.mnc.db.daoimp.UserDaoImp;
import com.ais.mnc.util.MncUtilities;

public class UserSignUpActivity extends AppCompatActivity{
    private static final String TAG = "UserSignUpActivity >>>";

    Toolbar toolbar;
    EditText email,password,name;
    CheckBox checkBox;
    ImageButton signup;
    Button signin;

    UserDaoImp mUserDaoImp;
    UserBean signup_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        initView();

        mUserDaoImp = new UserDaoImp(this);


        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                signup_user = new UserBean(
                        name.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString()
                );
                if (!mUserDaoImp.checkExist(signup_user.getUname(), signup_user.getEmail())) {
                    if (mUserDaoImp.createUser(signup_user)) {
                        MncUtilities.toastMessage(UserSignUpActivity.this, "Sign up done!");
                        MncUtilities.startNextActivity(UserSignUpActivity.this, UserLoginActivity.class, true);
                    } else {
                        MncUtilities.toastMessage(UserSignUpActivity.this, "Sign up error!");
                    }
                } else {
                    MncUtilities.toastMessage(UserSignUpActivity.this, "User or email exists ! ");
                }
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