package com.ais.mnc.view.motorhome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.OrderBean;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.OrderDao;
import com.ais.mnc.db.dao.VehicleDao;
import com.ais.mnc.db.daoimp.OrderDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.system.UserLoginActivity;
import com.squareup.picasso.Picasso;

public class VehicleDetailActivity extends AppCompatActivity {
    private static final String TAG = "VDetail Activity >>>";

    TabHost tabhost;
    ImageView vdtl_img;
    TextView vd_tv_name,
            vd_tv_type,
            vd_tv_year;

    FloatingActionButton vd_fab;

    VehicleBean currentVehicle;
    VehicleDao mVehicleDao;
    OrderDao mOrderDao;

    //order dialog elements

    EditText od_et_title;
    EditText od_et_fname;
    EditText od_et_lname;
    EditText od_et_phone;
    EditText od_et_datebg;
    EditText od_et_dateed;
    TextView od_et_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

        //draw the Toolbar and Tabs
        initTabs();

        //init view elements on the activity screen
        initView();

        currentVehicle = MncUtilities.currentVehicle;

        //set detail values
        Picasso.with(this)
                .load(currentVehicle.getImage())
                .into(vdtl_img);

        vd_tv_name.setText(currentVehicle.getVname());
        vd_tv_type.setText(currentVehicle.getType() + " Berth");

        //set float action button
        vd_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MncUtilities.currentUser != null) {
                    showOrderDialog();
                } else {
                    MncUtilities.previousClass = VehicleDetailActivity.class;
                    MncUtilities.startNextActivity(VehicleDetailActivity.this, UserLoginActivity.class, true);
                }
            }
        });
    }

    private void showOrderDialog() {
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        View orderView = LayoutInflater.from(this)
                .inflate(R.layout.order_add_layout, null);

        od_et_title = orderView.findViewById(R.id.od_et_title);
        od_et_fname = orderView.findViewById(R.id.od_et_fname);
        od_et_lname = orderView.findViewById(R.id.od_et_lname);
        od_et_phone = orderView.findViewById(R.id.od_et_phone);
        od_et_datebg = orderView.findViewById(R.id.od_et_datebg);
        od_et_dateed = orderView.findViewById(R.id.od_et_dateed);
        od_et_amount = orderView.findViewById(R.id.od_et_amount);

        od_et_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MncUtilities.showTitleDialog(VehicleDetailActivity.this, (TextView) od_et_title);
            }
        });

        od_et_datebg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MncUtilities.showDateDialog(VehicleDetailActivity.this, od_et_datebg);
            }
        });

        od_et_dateed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MncUtilities.showDateDialog(VehicleDetailActivity.this, od_et_dateed);
            }
        });

        builder.setView(orderView);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OrderBean newOrder = new OrderBean(
                        1,
                        MncUtilities.currentVehicle.getVid(),
                        MncUtilities.currentUser.getUid(),
                        od_et_datebg.getText() + "",
                        od_et_dateed.getText() + "",
                        Integer.parseInt(od_et_amount.getText() + ""),
                        "",  //TODO
                        "10",
                        od_et_amount.getText() + "",
                        od_et_amount.getText() + ""
                );
                mOrderDao = new OrderDaoImp(VehicleDetailActivity.this);
                mOrderDao.createOrder(newOrder);
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private void initView() {
        vdtl_img = findViewById(R.id.vdtl_img_top);
        vd_tv_name = findViewById(R.id.vd_tv_vname);
        vd_tv_type = findViewById(R.id.vd_tv_type);
        vd_tv_year = findViewById(R.id.vd_tv_year);
        vd_fab = findViewById(R.id.vdtl_fab);
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
