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
 * Created on 26/10/2018
 *
 * @author Shaw
 * @version 1.0
 */
public class VehicleViewHolder extends RecyclerView.ViewHolder {
    public ImageView vcard_img_item;
    public TextView  vcard_tv_desc;

    public VehicleViewHolder(@NonNull View itemView) {
        super(itemView);

        vcard_img_item = itemView.findViewById(R.id.vcard_img_item);
        vcard_tv_desc  = itemView.findViewById(R.id.vcard_tv_desc);
    }
}
