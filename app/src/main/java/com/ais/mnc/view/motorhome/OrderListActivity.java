package com.ais.mnc.view.motorhome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.OrderBean;
import com.ais.mnc.db.dao.OrderDao;
import com.ais.mnc.db.daoimp.OrderDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends AppCompatActivity {
    private static final String TAG = "OrderListActivity >>> ";

    RecyclerView recycle_olist;
    OrderDao mOrderDao;
    List<OrderBean> orderList;

    BottomNavigationView odlt_btm_nav;
    Toolbar olst_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        //check login states
        if (MncUtilities.currentUser == null) {
            MncUtilities.toastMessage(this, "Please log in first ! ");
            return;
        }

        //set toolbar
        olst_toolbar = findViewById(R.id.olst_toolbar);
        setSupportActionBar(olst_toolbar);
        ActionBar lvActionBar = getSupportActionBar();
        lvActionBar.setDisplayHomeAsUpEnabled(true);

        //achieve order list
        mOrderDao = new OrderDaoImp(this);
        orderList = mOrderDao.findByUID(MncUtilities.currentUser.getUid());

        //bind adapter to recycle view
        if (orderList != null) {
            Log.d(TAG, "  oooo list got, size :  " + orderList.size());
            recycle_olist = findViewById(R.id.recycle_olist);
            recycle_olist.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
            recycle_olist.setHasFixedSize(true);
            recycle_olist.setAdapter(new OrderAdapter(this, orderList));
            Log.d(TAG, "  oooo adapter ......");

//            odlt_btm_nav = findViewById(R.id.odlt_btm_nav);
//            odlt_btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Log.d(TAG, " bottom menu clicked ......");
//                    if (menuItem.getItemId() == R.id.odlt_nav_booking) {
//                        filterList(orderList, "10");
//                    } else if (menuItem.getItemId() == R.id.odlt_nav_progress) {
//                        filterList(orderList, "20");
//                    } else if (menuItem.getItemId() == R.id.odlt_nav_cancel) {
//                        filterList(orderList, "90");
//                    } else {
//                        filterList(orderList, "30");
//                    }
//                    return true;
//                }
//            });

        }
    }

    private void filterList (List<OrderBean> olist, String status){
        if ("0".equals(status)) {
            return;
        } else {
            Log.d(TAG, " filter clicked ......");
            ArrayList<OrderBean> returnList = new ArrayList<>();
            if (olist != null) {
                for (OrderBean bean : olist) {
                    if (status.equals(bean.getOstate())) {
                        returnList.add(bean);
                    }
                }
            }
            Log.d(TAG, " filter finished ......  : " + returnList.size());
            recycle_olist.setAdapter(new OrderAdapter(this, returnList));
        }
    }


    @Override
    public void onBackPressed() {
        if (MncUtilities.previousClass == null) {
            MncUtilities.startNextActivity(this, VehicleTypeActivity.class, false);
        } else {
            MncUtilities.startNextActivity(this, MncUtilities.previousClass, false);
        }
//        super.onBackPressed();
    }

}
