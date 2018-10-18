package com.ais.mnc.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ais.mnc.R;
import com.ais.mnc.db.UserDBHelper;

public class UserLoginActivity extends AppCompatActivity{
    public static final String TAG = "UserLoginActivity";

    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    UserDBHelper mUserDBHelper;

    String lv_name;
    String lv_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText) findViewById(R.id.et_uname);
        password = (EditText)findViewById(R.id.et_password);
        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signin = (ImageButton)findViewById(R.id.btn_signin);
        signup = (Button) findViewById(R.id.btn_signup);

        mUserDBHelper = new UserDBHelper(this);

        lv_name = email.getText() + "";
        lv_pwd = password.getText().toString();

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mUserDBHelper.doLogin(lv_name, lv_pwd)) {
                    Toast.makeText(UserLoginActivity.this, "Succ ", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(UserLoginActivity.this, UserSignUpActivity.class);
//                    startActivity(i);
                } else {
                    Toast.makeText(UserLoginActivity.this, "Error ", Toast.LENGTH_LONG).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserLoginActivity.this, UserSignUpActivity.class);
                startActivity(i);
            }
        });
    }
}