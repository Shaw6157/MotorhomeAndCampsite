package com.ais.mnc.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.VehicleBean;
import com.ais.mnc.db.dao.VehicleDao;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.adapter.VehicleCardAdapter;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;

public class VehicleTypeActivity extends AppCompatActivity {
    private static final String TAG = "VehicleTypeActivity >>>";

    SliderLayout vlst_slider;
    RecyclerView recycle_vtypelist;

    ArrayList<VehicleBean> vTypeList;
    VehicleDao lvVehicleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_type);


        vlst_slider = findViewById(R.id.vlst_slider);

        //get top deals
        initDealSlider();

        //set vehicle types datA
        initVehicleTypes();

        //set vehicle types adpter
        recycle_vtypelist = findViewById(R.id.vtyp_lyt_recycle);
//        recycle_vtypelist.setLayoutManager(new GridLayoutManager(this, 2));
        recycle_vtypelist.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        recycle_vtypelist.setHasFixedSize(true);
        recycle_vtypelist.setAdapter(new VehicleCardAdapter(this, vTypeList));

    }

    private void initDealSlider() {
        TextSliderView txtSliderView1 = new TextSliderView(this);
        txtSliderView1
                .description("Britz: 5% Long Hire Discount")
                .image(R.drawable.deal1)
//                .image("https://upload-images.jianshu.io/upload_images/2570030-a6c58e16d0b4f5d6.png")
                .setScaleType(BaseSliderView.ScaleType.Fit);
        txtSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                MncUtilities.toastMessage(VehicleTypeActivity.this, "first deal");
            }
        });

        TextSliderView txtSliderView2 = new TextSliderView(this);
        txtSliderView2.description("Apollo: Early Bird 5% Off")
                .image(R.drawable.deal2)
                .setScaleType(BaseSliderView.ScaleType.Fit);
        txtSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                MncUtilities.toastMessage(VehicleTypeActivity.this, "second deal");
            }
        });

        vlst_slider.addSlider(txtSliderView1);
        vlst_slider.addSlider(txtSliderView2);
    }

    private void initVehicleTypes() {
//        //CAN BE FROM DB, BUT DIDNOT
//        lvVehicleDao = new VehicleDaoImp(this);
//        vTypeList = lvVehicleDao.getAllTypes();
        vTypeList = new ArrayList<VehicleBean> (5);
        VehicleBean vehicleType1 = new VehicleBean();
        vehicleType1.setVname("Sleeps 2");
        vehicleType1.setImage("1");
        vehicleType1.setType("1");
        vTypeList.add(vehicleType1);

        VehicleBean vehicleType2 = new VehicleBean();
        vehicleType2.setVname("Sleeps 3");
        vehicleType2.setImage("1");
        vehicleType2.setType("2");
        vTypeList.add(vehicleType2);

        VehicleBean vehicleType3 = new VehicleBean();
        vehicleType3.setVname("Sleeps 4");
        vehicleType3.setImage("1");
        vehicleType3.setType("3");
        vTypeList.add(vehicleType3);

        VehicleBean vehicleType4 = new VehicleBean();
        vehicleType4.setVname("Sleeps 5");
        vehicleType4.setImage("1");
        vehicleType4.setType("4");
        vTypeList.add(vehicleType4);

        VehicleBean vehicleType5 = new VehicleBean();
        vehicleType5.setVname("Sleeps 6 or more");
        vehicleType5.setImage("1");
        vehicleType5.setType("5");
        vTypeList.add(vehicleType5);

        VehicleBean vehicleType6 = new VehicleBean();
        vehicleType6.setVname("Check All");
        vehicleType6.setImage("1");
        vehicleType6.setType("9");
        vTypeList.add(vehicleType6);
    }

    @Override
    protected void onDestroy() {
        vlst_slider.stopAutoCycle();
        super.onDestroy();
    }
}
