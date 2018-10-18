package com.ais.mnc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ais.mnc.bean.UserBean;

public class UserDBHelper extends SQLiteOpenHelper {
    public static final String TAG = "UserDBHelper";

    public static final String DATABSE_NAME = "dbUser";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tbUser";
    public static final String COL1_ID = "Uid";
    public static final String COL2_NAME = "Uname";
    public static final String COL3_EMAIL = "Email";
    public static final String COL4_PWD = "Password";
    public static final String COL5_TYPE = "Utype";

    //TODO
//    title
//    firstname
//    lastname
//    license type
//    init screen
//    del

    public UserDBHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME
                + " (" + COL1_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2_NAME + " TEXT, "
                + COL3_EMAIL+ " TEXT, "
                + COL4_PWD+ " TEXT, "
                + COL5_TYPE + " TEXT)";
        db.execSQL(create_table);

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_ID, 1);
        contentValues.put(COL2_NAME, "admin");
        contentValues.put(COL3_EMAIL, "shaw.yunz@gmail.com");
        contentValues.put(COL4_PWD, "adminshaw");
        contentValues.put(COL5_TYPE, "admin");
        db.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public boolean doSignUp(UserBean p_user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_NAME, p_user.getUname());
        contentValues.put(COL3_EMAIL, p_user.getEmail());
        contentValues.put(COL4_PWD, p_user.getPassword());
        contentValues.put(COL5_TYPE, "user");
        Log.d(TAG, "addData: Adding " + p_user.getUname() + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        return result == -1 ? false : true;
    }

    public boolean doLogin(String p_uid, String p_password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String str_pwd = "x";

        Cursor cursor = db.rawQuery(
                "SELECT " + COL4_PWD + " FROM " + TABLE_NAME
                + " WHERE " + COL2_NAME + " = '" + p_uid + "'", null);
        while (cursor.moveToNext()) {
            str_pwd = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return p_password.equals(str_pwd) ? true : false;
    }
}
