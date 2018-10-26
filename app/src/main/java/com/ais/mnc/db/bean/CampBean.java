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
//    public static final String CAMP_COL6_IMAGE = "Image";

    private int cid;
    private String cname;
    private String address;
    private String info;
    private String url;
    private String image;

    public CampBean() {

    }

    public CampBean(int pCid, String pCname, String pAddress, String pInfo, String pUrl, String pImage) {
        cid = pCid;
        cname = pCname;
        address = pAddress;
        info = pInfo;
        url = pUrl;
        image = pImage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
