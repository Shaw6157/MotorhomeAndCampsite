package com.ais.mnc.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.util.MncUtilities;

public class CampsiteDetailActivity extends AppCompatActivity {
    private static final String TAG = "CpDetailActivity >>> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campsite_detail);

        CampBean lvCurrentCpsite = MncUtilities.currentCpsite;

        Log.d(">>>>>>>>>>>>", "cp detail :" + lvCurrentCpsite.getCname());






    }
}
