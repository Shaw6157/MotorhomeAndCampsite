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
import com.ais.mnc.db.dao.UserDao;
import com.ais.mnc.db.daoimp.UserDaoImp;

import static com.ais.mnc.util.MncUtilities.*;

public class UserLoginActivity extends AppCompatActivity{
    private static final String TAG = "UserLoginActivity >>>";

    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    UserDao mUserDao;

    String lv_name;
    String lv_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        initView();

        mUserDao = new UserDaoImp(this);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                lv_name = email.getText() + "";
                lv_pwd = password.getText().toString();
                if (mUserDao.checkExist(lv_name, "")) {
                    if (lv_pwd.equals(mUserDao.getPassword(lv_name))) {
                        toastMessage(UserLoginActivity.this, "Succ ");
                        currentUser = mUserDao.findByName(lv_name);
                        startNextActivity(UserLoginActivity.this, CampsiteListActivity.class, false);
                    } else {
                        toastMessage(UserLoginActivity.this, "Wrong password! ");
                    }
                } else {
                    toastMessage(UserLoginActivity.this, "No such user! ");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startNextActivity(UserLoginActivity.this, UserSignUpActivity.class, false);
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