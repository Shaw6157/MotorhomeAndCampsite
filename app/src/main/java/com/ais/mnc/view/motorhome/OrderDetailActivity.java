package com.ais.mnc.view.motorhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ais.mnc.R;
import com.ais.mnc.util.MncUtilities;

public class OrderDetailActivity extends AppCompatActivity {

    EditText od_et_title;
    EditText od_et_fname;
    EditText od_et_lname;
    EditText od_et_phone;
    EditText od_et_datebg;
    EditText od_et_dateed;
    TextView od_et_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);


        od_et_title = findViewById(R.id.od_et_title);
        od_et_fname = findViewById(R.id.od_et_fname);
        od_et_lname = findViewById(R.id.od_et_lname);
        od_et_phone = findViewById(R.id.od_et_phone);
        od_et_datebg = findViewById(R.id.od_et_datebg);
        od_et_dateed = findViewById(R.id.od_et_dateed);
        od_et_amount = findViewById(R.id.od_et_amount);

        od_et_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MncUtilities.showTitleDialog(OrderDetailActivity.this, (TextView) od_et_title);
            }
        });


    }
}
