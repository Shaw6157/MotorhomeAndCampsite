package com.ais.mnc.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.view.adapter.ViewHolder.CampsiteViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 24/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class CampsiteListAdapter extends RecyclerView.Adapter<CampsiteViewHolder> {
    Context mContext;
    List<CampBean> campsiteList;

    public CampsiteListAdapter(Context pContext, List<CampBean> pCampsiteList) {
        mContext = pContext;
        campsiteList = pCampsiteList;
    }

    @NonNull
    @Override
    public CampsiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View campsiteView = LayoutInflater.from(mContext).inflate(R.layout.campsite_list_layout, parent, false);
        return new CampsiteViewHolder(campsiteView);
    }

    @Override
    public void onBindViewHolder(@NonNull CampsiteViewHolder campsiteViewHolder, int position) {
//        // can fetch pics from Google Picasa
//        Picasso.with(mContext)
//                .load(campsiteList.get(position).Link)
//                .into(campsiteViewHolder.img_campsite);

        // get from drawable pics
//        int resID = getResources().getIdentifier("campsite1", "drawable", "com.ais.mnc");
        campsiteViewHolder.img_campsite.setImageResource(R.drawable.campsite1);
        campsiteViewHolder.tv_campsite.setText(campsiteList.get(position).getCname());

    }

    @Override
    public int getItemCount() {
        return campsiteList.size();
    }
}
