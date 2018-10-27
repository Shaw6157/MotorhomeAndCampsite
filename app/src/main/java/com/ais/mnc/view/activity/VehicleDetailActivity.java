package com.ais.mnc.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import com.ais.mnc.R;
import com.ais.mnc.view.VehicleDetailAnimation;

public class VehicleDetailActivity extends AppCompatActivity {
    private static final String TAG = "VehicleDetailActivity >>>";

    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

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
}
