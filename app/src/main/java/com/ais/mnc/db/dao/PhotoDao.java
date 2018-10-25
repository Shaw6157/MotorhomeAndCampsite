package com.ais.mnc.db.dao;

import com.ais.mnc.db.bean.PhotoBean;

import java.util.List;

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
    //    public List<PhotoBean> findByCoreBar(CorePage cp);
    public List<PhotoBean> findAll();
}
