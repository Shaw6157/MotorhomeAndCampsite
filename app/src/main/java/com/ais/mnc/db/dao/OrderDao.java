package com.ais.mnc.db.dao;

import com.ais.mnc.db.bean.OrderBean;

import java.util.ArrayList;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 25/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public interface OrderDao {
    public boolean createOrder(OrderBean order);
    public boolean updateOrder(OrderBean order);
    public boolean deleteOrder(int oid);
    public OrderBean findById(int oid);
    //    public ArrayList<OrderBean> findByCoreBar(CorePage cp);
    public ArrayList<OrderBean> findAll();
}
