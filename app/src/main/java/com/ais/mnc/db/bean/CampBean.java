package com.ais.mnc.db.bean;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on:  22/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class CampBean {
    public static final String TAG = "CampBean";

//    //CAMPSITE TABLE CONSTANTS
//    public static final String CAMP_TABLE_NAME = "tbCampsite";
//    public static final String CAMP_COL1_CID = "CampsiteID";
//    public static final String CAMP_COL2_CNAME = "CampsiteName";
//    public static final String CAMP_COL3_ADDRESS = "Address";
//    public static final String CAMP_COL4_INFO = "Info";
//    public static final String CAMP_COL5_URL = "Url";

    private String cname;
    private String address;
    private String info;
    private String url;

    public CampBean(String pCname, String pAddress, String pInfo, String pUrl) {
        cname = pCname;
        address = pAddress;
        info = pInfo;
        url = pUrl;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String pCname) {
        cname = pCname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String pAddress) {
        address = pAddress;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String pInfo) {
        info = pInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String pUrl) {
        url = pUrl;
    }
}
