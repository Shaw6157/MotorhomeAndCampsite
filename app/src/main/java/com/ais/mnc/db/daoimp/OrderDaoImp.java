package com.ais.mnc.db.daoimp;

import android.content.Context;

import com.ais.mnc.db.MncDBHelper;
import com.ais.mnc.db.bean.OrderBean;
import com.ais.mnc.db.dao.OrderDao;

import java.util.List;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 25/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class OrderDaoImp implements OrderDao {
    private static final String TAG = "OrderDaoImp >>> ";

    private MncDBHelper mDBHelper;
    public OrderDaoImp(Context context) {
        mDBHelper = new MncDBHelper(context);
    }

    @Override
    public boolean createOrder(OrderBean order) {
        return false;
    }

    @Override
    public boolean updateOrder(OrderBean order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int oid) {
        return false;
    }

    @Override
    public OrderBean findById(int oid) {
        return null;
    }

    @Override
    public List<OrderBean> findAll() {
        return null;
    }
}
