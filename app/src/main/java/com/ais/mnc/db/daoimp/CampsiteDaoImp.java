package com.ais.mnc.db.daoimp;

import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.db.dao.CampsiteDao;

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

    @Override
    public boolean createCampsite(CampBean p_campsite) {
        return false;
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
        return null;
    }
}
