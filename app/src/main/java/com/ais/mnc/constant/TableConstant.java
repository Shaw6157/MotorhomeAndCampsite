package com.ais.mnc.constant;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 14/10/2018
 * @author Shaw
 * @version 1.0
 */
public class TableConstant {
    //USER TABLE CONSTANTS
    public static final String USER_TABLE_NAME = "tbUser";
    public static final String USER_COL1_UID = "UserID";
    public static final String USER_COL2_UNAME = "Username";
    public static final String USER_COL3_EMAIL = "Email";
    public static final String USER_COL4_PWD = "Password";
    public static final String USER_COL5_TYPE = "Usertype";

    //TODO
//    title
//    firstname
//    lastname
//    license type
//    init screen
//    del

    //VEHICLE TABLE CONSTANTS
    public static final String VEHICLE_TABLE_NAME = "tbVehicle";
    public static final String VEHICLE_COL1_VID = "VehicleID";
    public static final String VEHICLE_COL2_VNAME = "VehicleName";
    public static final String VEHICLE_COL3_PLATE = "Plate";
    public static final String VEHICLE_COL4_TYPE = "Type";
    public static final String VEHICLE_COL5_INFO = "Info";
    public static final String VEHICLE_COL6_PRICE = "Price";
    //TODO 54 cols more

    //CAMPSITE TABLE CONSTANTS
    public static final String CAMP_TABLE_NAME = "tbCampsite";
    public static final String CAMP_COL1_CID = "CampsiteID";
    public static final String CAMP_COL2_CNAME = "CampsiteName";
    public static final String CAMP_COL3_ADDRESS = "Address";
    public static final String CAMP_COL4_INFO = "Info";
    public static final String CAMP_COL5_URL = "Url";
    public static final String CAMP_COL6_IMAGE = "Image";

    //PHOTO TABLE CONSTANTS
    public static final String PHOTO_TABLE_NAME = "tbPhoto";
    public static final String PHOTO_COL1_PID = "PhotoID";
    public static final String PHOTO_COL2_CID = "CampsiteID";
    public static final String PHOTO_COL3_UID = "UserID";
    public static final String PHOTO_COL4_DATE = "PhotoDate";
    public static final String PHOTO_COL5_PATH = "Path";
    public static final String PHOTO_COL6_DESC = "Desc";
    public static final String PHOTO_COL7_DEL = "DelFlag";

    //ORDER TABLE CONSTANTS
    public static final String ORDER_TABLE_NAME = "tbOrder";
    public static final String ORDER_COL1_OID = "OrderID";
    public static final String ORDER_COL2_VID = "VehicleID";
    public static final String ORDER_COL3_UID = "UserID";
    public static final String ORDER_COL4_DATABG = "DateBegin";
    public static final String ORDER_COL5_DATAED = "DateEnd";
    public static final String ORDER_COL6_AMOUNT = "Amount";
    public static final String ORDER_COL7_DATA = "OrderDate";
    public static final String ORDER_COL8_STATE = "OrderState";
    public static final String ORDER_COL9_CONTACT = "ContactName";
    public static final String ORDER_COL10_PHONE = "ContactPhone";


    //TABLE CREATE STATEMENT
    //USER TABLE
    public static final String CREATE_USER_TABLE =
            "CREATE TABLE " + TableConstant.USER_TABLE_NAME + " ("
                    + TableConstant.USER_COL1_UID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TableConstant.USER_COL2_UNAME   + " TEXT, "
                    + TableConstant.USER_COL3_EMAIL   + " TEXT, "
                    + TableConstant.USER_COL4_PWD     + " TEXT, "
                    + TableConstant.USER_COL5_TYPE    + " TEXT)";
    //VEHICLE TABLE
    public static final String CREATE_VEHICLE_TABLE =
            "CREATE TABLE " + VEHICLE_TABLE_NAME + " ("
                    + VEHICLE_COL1_VID   + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + VEHICLE_COL2_VNAME + " TEXT, "
                    + VEHICLE_COL3_PLATE + " TEXT, "
                    + VEHICLE_COL4_TYPE  + " TEXT, "
                    + VEHICLE_COL5_INFO  + " TEXT, "
                    + VEHICLE_COL6_PRICE + " TEXT)";

    //CAMPSITE TABLE
    public static final String CREATE_CAMP_TABLE =
            "CREATE TABLE " + CAMP_TABLE_NAME + " ("
                    + CAMP_COL1_CID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + CAMP_COL2_CNAME   + " TEXT, "
                    + CAMP_COL3_ADDRESS + " TEXT, "
                    + CAMP_COL4_INFO    + " TEXT, "
                    + CAMP_COL5_URL     + " TEXT, "
                    + CAMP_COL6_IMAGE   + " TEXT)";

    //PHOTO TABLE
    public static final String CREATE_PHOTO_TABLE =
            "CREATE TABLE " + PHOTO_TABLE_NAME + " ("
                    + PHOTO_COL1_PID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + PHOTO_COL2_CID     + " INTEGER, "
                    + PHOTO_COL3_UID     + " INTEGER, "
                    + PHOTO_COL4_DATE    + " TEXT, "
                    + PHOTO_COL5_PATH    + " TEXT, "
                    + PHOTO_COL6_DESC    + " TEXT, "
                    + PHOTO_COL7_DEL     + " INTEGER)";

    //ORDER TABLE
    public static final String CREATE_ORDER_TABLE =
            "CREATE TABLE " + ORDER_TABLE_NAME + " ("
                    + ORDER_COL1_OID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ORDER_COL2_VID     + " INTEGER, "
                    + ORDER_COL3_UID     + " INTEGER, "
                    + ORDER_COL4_DATABG  + " INTEGER, "
                    + ORDER_COL5_DATAED  + " TEXT, "
                    + ORDER_COL6_AMOUNT  + " INTEGER, "
                    + ORDER_COL7_DATA    + " TEXT, "
                    + ORDER_COL8_STATE   + " TEXT, "
                    + ORDER_COL9_CONTACT + " TEXT, "
                    + ORDER_COL10_PHONE  + " TEXT)";
}
