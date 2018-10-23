package com.ais.mnc.db.daoimp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ais.mnc.db.bean.UserBean;
import com.ais.mnc.constant.TableConstant;
import com.ais.mnc.db.MncDBHelper;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.UserDao;

import java.util.List;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 20/10/2018
 * @author Shaw
 * @version 1.0
 */
public class UserDaoImp implements UserDao {
    private static final String TAG = "UserDAO >>> ";

    private MncDBHelper mDBHelper;
    public UserDaoImp(Context context) {
        mDBHelper = new MncDBHelper(context);
    }

    @Override
    public boolean createUser(UserBean p_user) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableConstant.USER_COL2_UNAME, p_user.getUname());
        contentValues.put(TableConstant.USER_COL3_EMAIL, p_user.getEmail());
        contentValues.put(TableConstant.USER_COL4_PWD, p_user.getPassword());
        contentValues.put(TableConstant.USER_COL5_TYPE, "user");
        long result = db.insert(TableConstant.USER_TABLE_NAME, null, contentValues);

        //log
        Log.d(TAG, ">>> insert:  " + p_user.getUname() + " to " + TableConstant.USER_TABLE_NAME);

        //close and return
        db.close();
        return result != -1;
    }

    @Override
    public String getPassword(String p_uname) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        String str_pwd = "x";
        Cursor cursor = db.rawQuery(
                "SELECT " + TableConstant.USER_COL4_PWD
                        + " FROM " + TableConstant.USER_TABLE_NAME
                        + " WHERE " + TableConstant.USER_COL2_UNAME
                        + " = '" + p_uname + "'", null);
        while (cursor.moveToNext()) {
            str_pwd = cursor.getString(0);
        }

        //log
        Log.d(TAG, ">>> getPassword: " + p_uname + " in " + TableConstant.USER_TABLE_NAME);

        //close and return
        cursor.close();
        db.close();
        return str_pwd;
    }

    @Override
    public UserBean findByName(String p_uname) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        UserBean lvUserBean = null;
        String selectQuery = "SELECT * FROM " + TableConstant.USER_TABLE_NAME
                + " WHERE " + TableConstant.USER_COL2_UNAME + " = '" + p_uname + "'";
        Log.d(TAG, "QUERY by name: " +selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
            lvUserBean = new UserBean(
                    c.getString(c.getColumnIndex(TableConstant.USER_COL2_UNAME)),
                    c.getString(c.getColumnIndex(TableConstant.USER_COL3_EMAIL)),
                    c.getString(c.getColumnIndex(TableConstant.USER_COL4_PWD))
            );
        }
        return lvUserBean;
    }

    @Override
    public List<UserBean> findAll() {
        return null;
    }

    @Override
    public boolean updateUser(UserBean p_user) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableConstant.USER_COL2_UNAME, p_user.getUname());
        values.put(TableConstant.USER_COL3_EMAIL, p_user.getEmail());
        values.put(TableConstant.USER_COL4_PWD, p_user.getPassword());

        // updating row
        long result = db.update(TableConstant.USER_TABLE_NAME, values,
                TableConstant.USER_COL2_UNAME + " = ?",
                new String[] { String.valueOf(p_user.getUname()) });

        //log
        Log.d(TAG, ">>> update: " + p_user.getUname() + " in " + TableConstant.USER_TABLE_NAME);

        //close and return
        db.close();
        return result != -1;
    }

    @Override
    public boolean deleteUser(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int result = db.delete(TableConstant.USER_TABLE_NAME,
                TableConstant.USER_COL1_UID + " = ?",
                new String[] { String.valueOf(id) });

        Log.d(TAG, ">>> delete: " + id + " in " + TableConstant.USER_TABLE_NAME);
        return result != -1;
    }

    @Override
    public boolean checkExist(String p_uname, String p_email) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        boolean flag = false;

        //log
        Log.d(TAG, ">>> checkExist: " + p_uname + " in " + TableConstant.USER_TABLE_NAME);

        //check user name
        Cursor cursor = db.rawQuery(
                "SELECT " + TableConstant.USER_COL4_PWD
                        + " FROM " + TableConstant.USER_TABLE_NAME
                        + " WHERE " + TableConstant.USER_COL2_UNAME
                        + " = '" + p_uname + "'", null);
        //log
        Log.d(TAG, ">>> checkExist  uuu: " + p_uname );
        if (cursor.moveToFirst()) {
            flag = true;
        }
        cursor.close();

        //check user email
        if (!flag && !"".equals(p_email)) {
            Cursor cursor2 = db.rawQuery(
                    "SELECT " + TableConstant.USER_COL4_PWD
                            + " FROM " + TableConstant.USER_TABLE_NAME
                            + " WHERE " + TableConstant.USER_COL3_EMAIL
                            + " = '" + p_email + "'", null);
            //log
            Log.d(TAG, ">>> checkExist  eee: " + p_email );
            if (cursor2.moveToFirst()) {
                flag = true;
            }
            cursor2.close();
        }

        Log.d(TAG, ">>> checkExist  rrreturn: " + flag );

        //close and return
        db.close();
        return flag;
    }

    public boolean removeUser(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        long result = db.delete(TableConstant.USER_TABLE_NAME,
                TableConstant.USER_COL1_UID + " = ?",
                new String[] { String.valueOf(id) });

        Log.d(TAG, ">>> remove: " + id + " in " + TableConstant.USER_TABLE_NAME);
        return result != -1;
    }
}
