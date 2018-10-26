package com.ais.mnc.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ais.mnc.R;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 24/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class CampsiteViewHolder extends RecyclerView.ViewHolder {

    public ImageView ccard_img_campsite;
    public TextView  ccard_tv_desc;

    public CampsiteViewHolder(@NonNull View camplistView) {
        super(camplistView);

        ccard_img_campsite = camplistView.findViewById(R.id.ccard_img_campsite);
        ccard_tv_desc = camplistView.findViewById(R.id.ccard_tv_desc);
    }
}
