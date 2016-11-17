package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.phone1000.admin.ecook.R;

import org.xutils.x;

public class Main1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        x.view().inject(this);

    }
    public void onClick(View view) {
        finish();
    }
}
