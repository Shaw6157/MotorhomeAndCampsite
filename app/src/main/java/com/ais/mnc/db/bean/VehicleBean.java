package com.ais.mnc.db.bean;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 20/10/2018
 * @author Shaw
 * @version 1.0
 */
public class VehicleBean {


//    //VEHICLE TABLE CONSTANTS
//    public static final String VEHICLE_TABLE_NAME = "tbVehicle";
//    public static final String VEHICLE_COL1_VID = "VehicleID";
//    public static final String VEHICLE_COL2_VNAME = "VehicleName";
//    public static final String VEHICLE_COL3_PLATE = "Plate";
//    public static final String VEHICLE_COL4_TYPE = "Type";
//    public static final String VEHICLE_COL5_INFO = "Info";
//    public static final String VEHICLE_COL6_PRICE = "Price";
//    //TODO 54 cols more


    private int vid;
    private String vname;
    private String plate;
    private String type;
    private String desc;
    private int price;
    private int feature0;
    private int feature1;
    private String image;

    public VehicleBean() {

    }

    public VehicleBean(int pVid, String pVname, String pPlate, String pType, String pDesc, int pPrice, boolean[] features) {
        vid = pVid;
        vname = pVname;
        plate = pPlate;
        type = pType;
//        image = pImage;
        desc = pDesc;
        price = pPrice;
        if (features != null && features.length > 0) {
            feature0 = features[0] ? 1 : 0;
            feature1 = features[1] ? 1 : 0;
        }
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String pVname) {
        vname = pVname;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String pPlate) {
        plate = pPlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String pType) {
        type = pType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String pImage) {
        image = pImage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String pDesc) {
        desc = pDesc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int pPrice) {
        price = pPrice;
    }

    public boolean getFeature0() {
        return feature0 != 0;
    }

    public void setFeature0(boolean pFeature0) {
        feature0 = pFeature0 ? 1 : 0;;
    }

    public boolean getFeature1() {
        return feature1 != 0;
    }

    public void setFeature1(boolean pFeature1) {
        feature1 = pFeature1 ? 1 : 0;;
    }
}
