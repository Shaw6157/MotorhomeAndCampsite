package com.ais.mnc.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.VehicleDao;
import com.ais.mnc.db.daoimp.VehicleDaoImp;
import com.ais.mnc.view.adapter.VehicleListAdapter;

import java.util.ArrayList;

public class VehicleListActivity extends AppCompatActivity {
    private static final String TAG = "VehicleListActivity >>>";

    RecyclerView recycle_vlst;

    VehicleDao mVehicleDao;
    ArrayList<VehicleBean> vehicleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        mVehicleDao = new VehicleDaoImp(this);
        vehicleList = mVehicleDao.findAll();

        Log.d(TAG, "select result: " + vehicleList.size());

        //set vehicle types adpter
        recycle_vlst = findViewById(R.id.recycle_vlist);
        recycle_vlst.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recycle_vlst.setHasFixedSize(true);
        recycle_vlst.setAdapter(new VehicleListAdapter(this, vehicleList));
    }
}
