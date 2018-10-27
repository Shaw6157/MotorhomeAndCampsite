package com.ais.mnc.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.VehicleDao;
import com.ais.mnc.db.daoimp.VehicleDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.VehicleDetailAnimation;
import com.squareup.picasso.Picasso;

public class VehicleDetailActivity extends AppCompatActivity {
    private static final String TAG = "VDetail Activity >>>";

    TabHost tabhost;
    ImageView vdtl_img;
    TextView vd_tv_name,
            vd_tv_type,
            vd_tv_year;

    VehicleBean currentVehicle;
    VehicleDao mVehicleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

//        Log.d(TAG, "init current vehicle ");
//        currentVehicle = MncUtilities.currentVehicle;
//        Log.d(TAG, "current vehicle :" + currentVehicle.getVname());


        //get vid from vehicle list activity
        String lvPara = this.getIntent().getExtras().get("para").toString();

        //get details of this vehicle
        mVehicleDao = new VehicleDaoImp(this);
        currentVehicle = mVehicleDao.findById(Integer.parseInt(lvPara));

        //draw the Toolbar and Tabs
        initTabs();

        //init view elements on the activity screen
        initView();

    }

    private void initView() {
        vdtl_img = findViewById(R.id.vdtl_img_top);
        vd_tv_name = findViewById(R.id.vd_tv_vname);
        vd_tv_type = findViewById(R.id.vd_tv_type);
        vd_tv_year = findViewById(R.id.vd_tv_year);

        Picasso.with(this)
                .load(currentVehicle.getImage())
                .into(vdtl_img);

        vd_tv_name.setText(currentVehicle.getVname());
        vd_tv_type.setText(currentVehicle.getType() + " Berth");
    }

    private void initTabs() {
        //init TabHost
        tabhost = findViewById(R.id.vdtl_tabhost);
        tabhost.setup();

        //Tab1
        String title_tab1 = getResources().getString(R.string.vdetail_tab1);
        TabHost.TabSpec spec =
                tabhost.newTabSpec(title_tab1)
                        .setContent(R.id.vdtl_tab1)
                        .setIndicator(title_tab1);
        tabhost.addTab(spec);

        //Tab2
        String title_tab2 = getResources().getString(R.string.vdetail_tab2);
        spec = tabhost.newTabSpec(title_tab2)
                .setContent(R.id.vdtl_tab2)
                .setIndicator(title_tab2);
        tabhost.addTab(spec);

        //set click animation Event
        tabhost.setOnTabChangedListener(new VehicleDetailAnimation(this, tabhost));
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "destroy");
        MncUtilities.currentVehicle = null;
        super.onDestroy();
    }
}
