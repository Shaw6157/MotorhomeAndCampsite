package com.ais.mnc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.ais.mnc.db.constant.TableConstant.*;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 18/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class MncDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "MncDBHelper >>> ";

    public static final String DATABSE_NAME = "dbMNC";
    public static final int DATABASE_VERSION = 1;

    public MncDBHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_VEHICLE_TABLE);
        db.execSQL(CREATE_CAMP_TABLE);
        db.execSQL(CREATE_ORDER_TABLE);
        db.execSQL(CREATE_PHOTO_TABLE);

        Log.d(TAG, "init............: ");
        //add default admin user account
//        ContentValues userV1 = new ContentValues();
//        userV1.put(TableConstant.USER_COL1_UID,    1);
//        userV1.put(TableConstant.USER_COL2_UNAME,  "admin");
//        userV1.put(TableConstant.USER_COL3_EMAIL,  "shaw.yunz@gmail.com");
//        userV1.put(TableConstant.USER_COL4_PWD,    "adminshaw");
//        userV1.put(TableConstant.USER_COL5_TYPE,   "admin");
//        db.insert(TableConstant.USER_TABLE_NAME, null, userV1);

        String query_u_init = "INSERT INTO "    + USER_TABLE_NAME
                + " SELECT 1 AS "               + USER_COL1_UID
                + ", 'admin' AS "               + USER_COL2_UNAME
                + ", 'shaw.yunz@gmail.com' AS " + USER_COL3_EMAIL
                + ", 'adminshaw' AS "           + USER_COL4_PWD
                + ", 'admin' AS "               + USER_COL5_TYPE
                + " UNION SELECT 2, 'aaa', 'aaa', 'aaa', 'user'"
                ;
        db.execSQL(query_u_init);

        String query_v_init = "INSERT INTO "    + VEHICLE_TABLE_NAME
                + " SELECT 1 AS "               + VEHICLE_COL1_VID
                + ", 'Lucky Rookie' AS "               + VEHICLE_COL2_VNAME
                + ", '2' AS " + VEHICLE_COL3_TYPE
                + ", 'Automatic' AS "           + VEHICLE_COL4_TRANSMISSION
                + ", '1997-1999' AS "               + VEHICLE_COL5_YEAR
                + ", '2.4L' AS "               + VEHICLE_COL6_ENGIN
                + ", 343 AS "               + VEHICLE_COL7_PRICE
                + ", 'https://tinyurl.com/mnc-vehicle0001' AS "               + VEHICLE_COL8_IMAGE
                + ", 'This vehicle is a well-loved campervan which is ideal for backpackers or the budget conscious who prefer saving money to driving the latest vehicle models.' AS "               + VEHICLE_COL9_INFO
                + ", 'Toyota Estima' AS "               + VEHICLE_COL10_MODEL
                + " UNION SELECT 2, 'Original Black Sheep', '2', 'Automatic', '2001', '3400', 449, 'https://tinyurl.com/mnc-vehicle0001',"
                + " 'Some brief introduction about Black sheep', 'Toyota Grandvia'"
                + " UNION SELECT 3, 'Sleepervan', '3', 'Automatic', '1996', '2000cc', 451, 'https://tinyurl.com/mnc-vehicle0001',"
                + " 'this is one of our best seller! check it out now!', 'Toyota'"
                ;


        Log.d(TAG, "init............: " + query_v_init);

        db.execSQL(query_v_init);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VEHICLE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CAMP_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PHOTO_TABLE_NAME);
        this.onCreate(db);
    }
}
