package com.ais.mnc.db.daoimp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ais.mnc.constant.TableConstant;
import com.ais.mnc.db.ColumnIndexCache;
import com.ais.mnc.db.MncDBHelper;
import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.CampsiteDao;

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
public class CampsiteDaoImp implements CampsiteDao {
    private static final String TAG = "CampsiteDaoImp >>> ";

    private MncDBHelper mDBHelper;
    public CampsiteDaoImp(Context context) {
        mDBHelper = new MncDBHelper(context);
    }

    @Override
    public boolean createCampsite(CampBean p_campsite) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues campValues = new ContentValues();
        campValues.put(TableConstant.CAMP_COL2_CNAME,   p_campsite.getCname());
        campValues.put(TableConstant.CAMP_COL3_ADDRESS, p_campsite.getAddress());
        campValues.put(TableConstant.CAMP_COL4_INFO,    p_campsite.getInfo());
        campValues.put(TableConstant.CAMP_COL5_URL,     p_campsite.getUrl());
        long result = db.insert(TableConstant.CAMP_TABLE_NAME, null, campValues);

        //log
        Log.d(TAG, ">>> insert:  " + p_campsite.getCname() + " to " + TableConstant.CAMP_TABLE_NAME);

        //close and return
        db.close();
        return result != -1;
    }

    @Override
    public boolean updateCampsite(CampBean p_campsite) {
        return false;
    }

    @Override
    public boolean deleteCampsite(int cid) {
        return false;
    }

    @Override
    public CampBean findById(int cid) {
        return null;
    }

    @Override
    public List<CampBean> findAll() {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TableConstant.CAMP_TABLE_NAME;
        Log.d(TAG, "QUERY: " +selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            List<CampBean> campsiteList = new ArrayList<CampBean>(c.getCount());
            ColumnIndexCache cache = new ColumnIndexCache();

            // looping through all rows and adding to list
            do {
                campsiteList.add(
                        new CampBean(
                                c.getString(c.getColumnIndex(TableConstant.CAMP_COL1_CID)),
                                c.getString(c.getColumnIndex(TableConstant.CAMP_COL2_CNAME)),
                                c.getString(c.getColumnIndex(TableConstant.CAMP_COL3_ADDRESS)),
                                c.getString(c.getColumnIndex(TableConstant.CAMP_COL4_INFO)),
                                c.getString(c.getColumnIndex(TableConstant.CAMP_COL5_URL))
                        ));
            } while (c.moveToNext());
            cache.clear();
            return campsiteList;
        }
        return null;
    }
}
