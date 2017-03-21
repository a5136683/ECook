package com.phone1000.admin.ecook.activity;


import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
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
    float oldX = 0 ;
    float oldY = 0;
    float newX = 0;
    float newY = 0;
    @ViewInject(R.id.full)
    private ImageView full = null;
    private boolean flag = true;
    private AudioManager audioManager;
    private io.vov.vitamio.widget.VideoView vv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_ping);
        x.view().inject(this);
        Vitamio.isInitialized(this);
        initView();

//        setListener();
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置默认横屏播放
    }
//
//    private void setListener() {
//        full.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ShiPingActivity.this.getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                }else if(ShiPingActivity.this.getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                }
//            }
//        });
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("test","摁下了");
                oldX = event.getX();
                oldY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("test","滑动了");
                newX = event.getX();
                newY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                Log.d("test","滑动结束了");
                if(newX - oldX > 0 && Math.abs(newX-oldX)>20){
                    Log.d("test","向右滑动了");
                }
                if(newX - oldX < 0 && Math.abs(newX-oldX)>20){
                    Log.d("test","向左滑动了");
                }
                if(newY - oldY > 0 && Math.abs(newY-oldY)>20){
                    Log.d("test","向下滑动了");
                }
                if(newY - oldY < 0 && Math.abs(newY-oldY)>20){
                    Log.d("test","向上滑动了");
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test","----------onRestart-------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","----------onStart-------------");
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
