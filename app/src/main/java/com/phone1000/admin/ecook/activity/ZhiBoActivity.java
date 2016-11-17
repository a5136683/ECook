package com.phone1000.admin.ecook.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.phone1000.admin.ecook.R;

import io.vov.vitamio.widget.MediaController;

public class ZhiBoActivity extends AppCompatActivity {
    private Intent intent = null;
    private String Vedio = null;
    private io.vov.vitamio.widget.VideoView vv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_bo);

        initView();

    }
    private void initView() {
        intent = getIntent();
        Vedio = intent.getStringExtra("Vedio");
        vv = (io.vov.vitamio.widget.VideoView) findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse(Vedio));

        vv.setMediaController(new MediaController(this));
     }
    }
