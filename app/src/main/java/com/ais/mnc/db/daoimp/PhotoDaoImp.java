package com.ais.mnc.db.daoimp;

import android.content.Context;

import com.ais.mnc.db.MncDBHelper;
import com.ais.mnc.db.bean.PhotoBean;
import com.ais.mnc.db.dao.PhotoDao;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 25/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class PhotoDaoImp implements PhotoDao {
    private static final String TAG = "PhotoDaoImp >>> ";

    private MncDBHelper mDBHelper;
    public PhotoDaoImp(Context context) {
        mDBHelper = new MncDBHelper(context);
    }

    @Override
    public boolean createPhoto(PhotoBean photo) {
        return false;
    }

    @Override
    public boolean updatePhoto(PhotoBean photo) {
        return false;
    }

    @Override
    public boolean deletePhoto(int pid) {
        return false;
    }

    @Override
    public PhotoBean findById(int pid) {
        return null;
    }

    @Override
    public ArrayList<PhotoBean> findAll() {
        return null;
    }
}
