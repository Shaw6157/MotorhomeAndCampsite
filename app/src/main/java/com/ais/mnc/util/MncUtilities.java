package com.ais.mnc.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ais.mnc.db.bean.CampBean;
import com.ais.mnc.db.bean.PhotoBean;
import com.ais.mnc.db.bean.UserBean;
import com.ais.mnc.db.bean.VehicleBean;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Copyright (C) 2018 CYu AIS. All rights reserved.
 * Description:
 * Created on 18/10/2018
 * @author Shaw
 * @version 1.0
 */
public class MncUtilities {
    private static final String TAG = "MncUtilities >>> ";

    public static UserBean currentUser = null;
    public static CampBean currentCpsite = null;
    public static VehicleBean currentVehicle = null;
    public static String currentVehicleType = null;
    public static ArrayList<PhotoBean> currentPhotoList = null;

    public static void startNextActivity(Context context, Class c, boolean isFinish){
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
        if (isFinish){
            ((Activity)context).finish();
        }
    }

    public static void startNextActivity(Context context, Class c, String argu, boolean isFinish){
        Intent intent = new Intent(context, c);
        if (argu != null && !"".equals(argu)) {
            intent.putExtra("para", argu);
        }
        context.startActivity(intent);
        if (isFinish){
            ((Activity)context).finish();
        }
    }

    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());   //yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateString(long date) {
        Date d = new Date(date + 24*60*60*1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(d);
    }

    public static String getDateLongString(long date){
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(d);
    }

    public static void showTitleDialog(Context context, final TextView textView) {
        final String[] titles = new String[]{"Mr.", "Mrs", "Dr", "Miss", "Ms"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setSingleChoiceItems(titles, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                textView.setText(titles[position]);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void setMncImage(Context context, String str_img, ImageView vImg) {
        Picasso.with(context)
                .load(str_img)
                .into(vImg);
    }

}
