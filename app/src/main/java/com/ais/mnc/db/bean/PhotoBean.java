package com.ais.mnc.db.bean;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 25/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class PhotoBean {
    private String pid;
    private String cid;
    private String uid;
    private String date;
    private String path;
    private String desc;
    private int del;

    public PhotoBean() {

    }

    public PhotoBean(String pid, String cid, String uid, String date, String path, String desc, boolean del) {
        this.pid = pid;
        this.cid = cid;
        this.uid = uid;
        this.date = date;
        this.path = path;
        this.desc = desc;
        this.del = del ? 1 : 0;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean getDel() {
        return del != 0;
    }

    public void setDel(boolean del) {
        this.del = del ? 1 : 0;
    }

    public void setDel(int del) {
        this.del = del;
    }

}
