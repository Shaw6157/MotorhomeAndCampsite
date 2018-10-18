package com.ais.mnc.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.mnc.utils
 * @Description:
 * @author: Shaw
 * @date: 18/10
 */
public class MncUtilities {
    public static final String TAG = "MncUtilities";

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

}
