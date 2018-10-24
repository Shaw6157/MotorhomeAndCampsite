package com.ais.mnc.view.adapter.ViewHolder;

import android.content.Context;
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

    public ImageView img_campsite;
    public TextView tv_campsite;

    public CampsiteViewHolder(View camplistView) {
        super(camplistView);

        img_campsite = camplistView.findViewById(R.id.clst_img_campsite);
        tv_campsite = camplistView.findViewById(R.id.clst_tv_campsite);
    }
}
