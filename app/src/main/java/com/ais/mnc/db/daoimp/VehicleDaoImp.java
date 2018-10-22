package com.ais.mnc.db.daoimp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.VehicleDao;

import java.util.List;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 21/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class VehicleDaoImp implements VehicleDao {
    private static final String TAG = "VehicleDaoImp >>> ";


    @Override
    public boolean createVehicle(VehicleBean p_vehicle) {
        return false;
    }

    @Override
    public boolean updateVehicle(VehicleBean p_vehicle) {
        return false;
    }

    @Override
    public boolean deleteVehicle(int pid) {
        return false;
    }

    @Override
    public VehicleBean findById(int pid) {
        return null;
    }

    @Override
    public List<VehicleBean> findAll() {
        return null;
    }



//    /**
//     * get single todo
//     */
//    public Todo getTodo(long todo_id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
//                + KEY_ID + " = " + todo_id;
//
//        Log.e(LOG, selectQuery);
//
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        if (c != null)
//            c.moveToFirst();
//
//        Todo td = new Todo();
//        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
//        td.setNote((c.getString(c.getColumnIndex(KEY_TODO))));
//        td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));
//
//        return td;
//    }
//
//    /**
//     * getting all todos
//     * */
//    public List<Todo> getAllToDos() {
//        List<Todo> todos = new ArrayList<Todo>();
//        String selectQuery = "SELECT  * FROM " + TABLE_TODO;
//
//        Log.e(LOG, selectQuery);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (c.moveToFirst()) {
//            do {
//                Todo td = new Todo();
//                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
//                td.setNote((c.getString(c.getColumnIndex(KEY_TODO))));
//                td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));
//
//                // adding to todo list
//                todos.add(td);
//            } while (c.moveToNext());
//        }
//
//        return todos;
//    }
//
}
