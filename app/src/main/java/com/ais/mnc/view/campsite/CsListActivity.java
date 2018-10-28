package com.ais.mnc.view.campsite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.db.dao.CampsiteDao;
import com.ais.mnc.db.daoimp.CampsiteDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.adapter.CampsiteListAdapter;

public class CsListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "CsListActivity >>> ";

    RecyclerView recycle_clist;
    TextView dwr_tv_uid, dwr_tv_email;

    CampsiteDao lvCampsiteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campsite_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                MncUtilities.startNextActivity(CsListActivity.this, CsMapActivity.class, false);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //init Campsite
        initCampsites();

        //set user info to drawer
        View headerView = navigationView.getHeaderView(0);
        dwr_tv_uid   = headerView.findViewById(R.id.dwr_tv_uid);
        dwr_tv_email = headerView.findViewById(R.id.dwr_tv_email);

        if (MncUtilities.currentUser == null) {
            dwr_tv_uid.setText("Guest");
            dwr_tv_email.setText("Login to check more info.");
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
                new CampsiteListAdapter(
                        this, new CampsiteDaoImp(this).findAll()));
    }

    private void initCampsites() {//init campstes
        lvCampsiteDao = new CampsiteDaoImp(this);
        CampBean camp1 = new CampBean();
        camp1.setAddress("225 Sandringham Rd, Sandringham, Auckland 1025");
        camp1.setCname("Gribblehirst Park");
        camp1.setInfo("Great Park for the kids variety of equipment but if one is broken would be nice to get it fixed. It is a Hugh park with space for running around playing but the toilet facilities should be checked routinely as in the middle of the day they are disgusting sometimes no toilet paper. Parks are a value place for our children the upkeep needs a plan on a routine for maintenance.");
        camp1.setUrl("https://cityvision.org.nz/our-projects/the-transformation-of-gribblehirst-park/");
//        camp1.setImage("https://tinyurl.com/mnc-campsite0001");
        camp1.setImage("https://cityvision.org.nz/wp-content/uploads/2016/09/WP_20140322_028-1080x675.jpg");
        camp1.setFeatures("Motorhome plug / Potable Water / Toilet");
        camp1.setLAT(-36.880514);
        camp1.setLNG(174.738549);

        CampBean camp2 = new CampBean();
        camp2.setAddress("27 Summit Dr, Mount Albert, Auckland 1025");
        camp2.setCname("Mount Albert - Owairaka Domain");
        camp2.setInfo("Fun short walk around the crater. There's a dirt path that takes you around the narrow rim or you can follow the road around. There is a number of side tracks you can take, great walk for kids with fantastic views");
        camp2.setUrl("https://maps.me/catalog/recreation/leisure-park/mount-albert-owairaka-domain--9223372036869264309/");
        camp2.setImage("https://tinyurl.com/mnc-campsite0002");  //TODO
        camp2.setFeatures("Motorhome plug / Potable Water / Shower / Toilet / Self Contained OK");
        camp2.setLAT(-36.890308);
        camp2.setLNG(174.720407);

        CampBean camp3 = new CampBean();
        camp3.setAddress("Heron Park, Waterview, Auckland 1026");
        camp3.setCname("Heron Park");
        camp3.setInfo("A nice tidy and cozy park, with kids playground there.");
        camp3.setUrl("https://cityvision.org.nz/news/planting-for-the-future-city-visions-commitment-to-the-environment/");
        //        camp3.setImage("https://tinyurl.com/mnc-campsite0001");
        camp3.setImage("https://cityvision.org.nz/wp-content/uploads/2016/10/WP_20160730_14_19_50_Pro-Copy-300x169.jpg");
        camp3.setFeatures("Motorhome plug / Potable Water");
        camp3.setLAT(-36.885698);
        camp3.setLNG(174.698070);
        //-36.885698, 174.698070

        CampBean camp4 = new CampBean();
        camp4.setAddress("34 Binsted Rd, New Lynn, Auckland 0600");
        camp4.setCname("Ken Maunder Park");
        camp4.setInfo("Good for a stop to eat lunch while on the run. Bring your own lunch of course.");
        camp4.setUrl("https://www.eventfinda.co.nz/venue/ken-maunder-park-auckland");
        camp4.setImage("https://i1.wp.com/in-the-back-of-the.net/wp-content/uploads/2012/05/19.jpg");
        camp4.setFeatures("Shower / Toilet");
        camp4.setLAT(-36.900853);
        camp4.setLNG(174.681559);
        //-36.900853, 174.681559

        lvCampsiteDao.createCampsite(camp1);
        lvCampsiteDao.createCampsite(camp2);
        lvCampsiteDao.createCampsite(camp3);
        lvCampsiteDao.createCampsite(camp4);
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
            MncUtilities.toastMessage(this, "Not done yet.");
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

        } else if (id == R.id.nav_cp_map) {
            MncUtilities.startNextActivity(this, CsMapActivity.class, false);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
