package com.phone1000.admin.ecook.activity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;

public class ShiPingActivity extends AppCompatActivity {
    private Intent intent = null;
    private String Vedio = null;
    private TextView will_gone = null;
    @ViewInject(R.id.full)
    private ImageView full = null;
    private boolean flag = true;
    private io.vov.vitamio.widget.VideoView vv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_ping);
        x.view().inject(this);
        Vitamio.isInitialized(this);
        initView();
        setListener();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置默认横屏播放
    }

    private void setListener() {
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiPingActivity.this,Shipin2Activity.class);
                intent.putExtra("video",Vedio);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        will_gone = (TextView) findViewById(R.id.will_gone);
        intent = getIntent();
        Vedio = intent.getStringExtra("video");
        vv = (io.vov.vitamio.widget.VideoView) findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse(Vedio));

        vv.setMediaController(new MediaController(this));
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // optional need Vitamio 4.0
                mediaPlayer.setPlaybackSpeed(1.0f);
                will_gone.setVisibility(View.GONE);
            }
        });

        //  vv.start();
    }

}
