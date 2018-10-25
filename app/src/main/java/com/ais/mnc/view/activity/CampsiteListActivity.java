package com.ais.mnc.view.activity;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ais.mnc.R;
import com.ais.mnc.constant.TableConstant;
import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.db.dao.CampsiteDao;
import com.ais.mnc.db.daoimp.CampsiteDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.adapter.CampsiteListAdapter;

public class CampsiteListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recycle_clist;
    TextView dwr_tv_uid, dwr_tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campsite_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //init campstes
        CampsiteDao lvCampsiteDao = new CampsiteDaoImp(this);
        CampBean camp1 = new CampBean();
        camp1.setAddress("aaaaaaa");
        camp1.setCname("Camp AAA");
        camp1.setInfo("asdas");
        camp1.setUrl("aa");

        CampBean camp2 = new CampBean();
        camp2.setAddress("bbbb");
        camp2.setCname("Camp BB");
        camp2.setInfo("Camp");
        camp2.setUrl("Camp");

        CampBean camp3 = new CampBean();
        camp3.setAddress("Camp");
        camp3.setCname("Camp CCCC");
        camp3.setInfo("Camp");
        camp3.setUrl("Camp");

        CampBean camp4 = new CampBean();
        camp4.setAddress("Camp");
        camp4.setCname("Camp D");
        camp4.setInfo("Camp");
        camp4.setUrl("Camp");

        lvCampsiteDao.createCampsite(camp1);
        lvCampsiteDao.createCampsite(camp2);
        lvCampsiteDao.createCampsite(camp3);
        lvCampsiteDao.createCampsite(camp4);

        //set user info to drawer
        View headerView = navigationView.getHeaderView(0);
        dwr_tv_uid   = headerView.findViewById(R.id.dwr_tv_uid);
        dwr_tv_email = headerView.findViewById(R.id.dwr_tv_email);

        if (MncUtilities.currentUser == null) {
            MncUtilities.toastMessage(this, "not login");
        } else {
            dwr_tv_uid.setText(MncUtilities.currentUser.getUname());
            dwr_tv_email.setText(MncUtilities.currentUser.getEmail());
        }

        //set context campsite list
        recycle_clist = findViewById(R.id.clst_lyt_recycle);
        recycle_clist.setLayoutManager(new GridLayoutManager(this, 2));
        recycle_clist.setHasFixedSize(true);
        recycle_clist.setAdapter(
                new CampsiteListAdapter(this,
                        new CampsiteDaoImp(this).findAll()));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
