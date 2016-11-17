package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class GeRenActivity extends AppCompatActivity implements View.OnClickListener{
    @ViewInject(R.id.cancel)
    private TextView cancel;
    @ViewInject(R.id.mine_qq)
    private LinearLayout mine_qq;
    @ViewInject(R.id.mine_weibo)
    private LinearLayout mine_weibo;
    @ViewInject(R.id.mine_msg)
    private LinearLayout mine_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_ren);
        ShareSDK.initSDK(this);//初始化
        x.view().inject(this);//注解注入初始化
        setListener();
    }

    private void setListener() {
        cancel.setOnClickListener(this);
        mine_weibo.setOnClickListener(this);
        mine_qq.setOnClickListener(this);
        mine_msg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel:
                finish();
                break;
            case R.id.mine_msg:
                break;
            case R.id.mine_qq:
                Platform qq= ShareSDK.getPlatform(this, QQ.NAME);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                    }
                });
                qq.authorize();
                break;
            case R.id.mine_weibo:
                break;
        }

    }
}
