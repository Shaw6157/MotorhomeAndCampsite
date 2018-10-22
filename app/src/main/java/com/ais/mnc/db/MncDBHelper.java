package com.ais.mnc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ais.mnc.constant.TableConstant;

public class MncDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "MncDBHelper >>> ";

    public static final String DATABSE_NAME = "dbMNC";
    public static final int DATABASE_VERSION = 1;

    public MncDBHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableConstant.CREATE_USER_TABLE);
        db.execSQL(TableConstant.CREATE_VEHICLE_TABLE);
        db.execSQL(TableConstant.CREATE_CAMP_TABLE);

        //add default admin user account
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableConstant.USER_COL1_UID,    1);
        contentValues.put(TableConstant.USER_COL2_UNAME,  "admin");
        contentValues.put(TableConstant.USER_COL3_EMAIL,  "shaw.yunz@gmail.com");
        contentValues.put(TableConstant.USER_COL4_PWD,    "adminshaw");
        contentValues.put(TableConstant.USER_COL5_TYPE,   "admin");
        db.insert(TableConstant.USER_TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableConstant.USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TableConstant.VEHICLE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TableConstant.CAMP_TABLE_NAME);
        this.onCreate(db);
    }
}
