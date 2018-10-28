package com.ais.mnc.view.campsite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.PhotoBean;
import com.ais.mnc.db.daoimp.CampsiteDaoImp;
import com.ais.mnc.util.MncUtilities;
import com.ais.mnc.view.adapter.CampsiteListAdapter;
import com.ais.mnc.view.adapter.PhotoListAdapter;
import com.jelly.mango.ImageSelectListener;
import com.jelly.mango.Mango;
import com.jelly.mango.MultiplexImage;

import java.util.ArrayList;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity {
    private static final String TAG = "PhotoListActivity >>> ";

    RecyclerView recycle_plist;

    List<MultiplexImage> photoList;
    PhotoListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        List<PhotoBean> images = new ArrayList<PhotoBean>();
        PhotoBean bean = new PhotoBean();
        bean.setPath("https://tinyurl.com/mnc-vehicle0001");
        images.add(bean);
        images.add(bean);
        images.add(bean);
        images.add(bean);

        //set photo list
        recycle_plist = findViewById(R.id.ptlt_recycle_view);
        recycle_plist.setLayoutManager(new GridLayoutManager(this, 3));
        recycle_plist.setHasFixedSize(true);
        recycle_plist.setAdapter(new PhotoListAdapter(this, images));//MncUtilities.currentPhotoList));

    }
}
