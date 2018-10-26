package com.ais.mnc.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ais.mnc.R;
import com.ais.mnc.db.bean.VehicleBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 26/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class VehicleAdapter extends RecyclerView.Adapter<VehicleViewHolder>{

    Context mContext;
    List<VehicleBean> vehicleList;

    public VehicleAdapter(Context context, List<VehicleBean> vehicleList) {
        mContext = context;
        this.vehicleList = vehicleList;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vTypeView = LayoutInflater.from(mContext).inflate(R.layout.vehicle_card_layout, viewGroup, false);
        return new VehicleViewHolder(vTypeView);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder vehicleViewHolder, int i) {
        Picasso.with(mContext)
                .load(vehicleList.get(i).getImage())
                .into(vehicleViewHolder.vcard_img_item);
        vehicleViewHolder.vcard_tv_desc.setText(vehicleList.get(i).getVname());
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }
}
