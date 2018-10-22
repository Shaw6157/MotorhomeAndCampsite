package com.ais.mnc.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.SimpleDateFormat;
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

    public static void startNextActivity(Context context, Class c, boolean isFinish){
        Intent intent = new Intent(context,c);
        context.startActivity(intent);
        if (isFinish){
            ((Activity)context).finish();
        }
    }

    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}
