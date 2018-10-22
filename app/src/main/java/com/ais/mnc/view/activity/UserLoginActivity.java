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
import com.ais.mnc.db.daoimp.UserDaoImp;
import com.ais.mnc.util.MncUtilities;

public class UserLoginActivity extends AppCompatActivity{
    private static final String TAG = "UserLoginActivity >>>";

    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    UserDaoImp mUserDaoImp;

    String lv_name;
    String lv_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        initView();

        mUserDaoImp = new UserDaoImp(this);

        lv_name = email.getText() + "";
        lv_pwd = password.getText().toString();

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!mUserDaoImp.checkExist(lv_name, "")) {
                    if (lv_pwd.equals(mUserDaoImp.getPassword(lv_name))) {
                        MncUtilities.toastMessage(UserLoginActivity.this, "Succ ");
//                        MncUtilities.startNextActivity(UserLoginActivity.this, UserSignUpActivity.class, false);
                    } else {
                        MncUtilities.toastMessage(UserLoginActivity.this, "Wrong password! ");
                    }
                } else {
                    MncUtilities.toastMessage(UserLoginActivity.this, "No such user! ");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MncUtilities.startNextActivity(UserLoginActivity.this, UserSignUpActivity.class, false);
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText) findViewById(R.id.et_uname);
        password = (EditText)findViewById(R.id.et_password);
        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signin = (ImageButton)findViewById(R.id.btn_signin);
        signup = (Button) findViewById(R.id.btn_signup);
    }
}