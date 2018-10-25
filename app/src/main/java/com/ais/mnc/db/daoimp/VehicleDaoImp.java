package com.ais.mnc.db.daoimp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ais.mnc.constant.TableConstant;
import com.ais.mnc.db.ColumnIndexCache;
import com.ais.mnc.db.MncDBHelper;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.VehicleDao;

import java.util.ArrayList;
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

    private MncDBHelper mDBHelper;
    public VehicleDaoImp(Context context) {
        mDBHelper = new MncDBHelper(context);
    }

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
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        VehicleBean vehicle = null;
        String selectQuery = "SELECT * FROM " + TableConstant.VEHICLE_TABLE_NAME
                + " WHERE " + TableConstant.VEHICLE_COL1_VID + " = " + pid;
        Log.d(TAG, "QUERY by id: " +selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            vehicle = new VehicleBean(
                    c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL1_VID)),
                    c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL2_VNAME)),
                    c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL3_PLATE)),
                    c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL4_TYPE)),
                    c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL5_INFO)),
                    c.getInt(c.getColumnIndex(TableConstant.VEHICLE_COL6_PRICE)),
                    null
            );
        }
        return vehicle;
    }

    @Override
    public List<VehicleBean> findAll() {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TableConstant.VEHICLE_TABLE_NAME;
        Log.d(TAG, "QUERY: " +selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            List<VehicleBean> vehicleList = new ArrayList<VehicleBean>(c.getCount());
            ColumnIndexCache cache = new ColumnIndexCache();

            // looping through all rows and adding to list
            do {
                vehicleList.add(
                        new VehicleBean(
                                c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL1_VID)),
                                c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL2_VNAME)),
                                c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL3_PLATE)),
                                c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL4_TYPE)),
                                c.getString(c.getColumnIndex(TableConstant.VEHICLE_COL5_INFO)),
                                c.getInt(c.getColumnIndex(TableConstant.VEHICLE_COL6_PRICE)),
                                null
                ));
            } while (c.moveToNext());
            cache.clear();
            return vehicleList;
        }
        return null;
    }
}
