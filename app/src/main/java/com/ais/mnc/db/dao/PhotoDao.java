package com.ais.mnc.db.dao;

import com.ais.mnc.db.bean.PhotoBean;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 25/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public interface PhotoDao {
    public boolean createPhoto(PhotoBean photo);
    public boolean updatePhoto(PhotoBean photo);
    public boolean deletePhoto(int pid);
    public PhotoBean findById(int pid);
    public ArrayList<PhotoBean> findByCID(int cid);
    public ArrayList<PhotoBean> findByUID(int uid);
    //    public ArrayList<PhotoBean> findByCoreBar(CorePage cp);
    public ArrayList<PhotoBean> findAll();
}
