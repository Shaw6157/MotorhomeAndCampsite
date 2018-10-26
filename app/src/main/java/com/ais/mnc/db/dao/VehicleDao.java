package com.ais.mnc.db.dao;

import com.ais.mnc.db.bean.VehicleBean;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on {DATE}
 *
 * @author Shaw
 * @version 1.0
 */
public interface VehicleDao {
    public boolean createVehicle(VehicleBean p_vehicle);
    public boolean updateVehicle(VehicleBean p_vehicle);
    public boolean deleteVehicle(int pid);
    public VehicleBean findById(int pid);
    //    public ArrayList<VehicleBean> findByCoreBar(CorePage cp);
    public ArrayList<VehicleBean> findAll();
    public ArrayList<String> getAllTypes();
}
