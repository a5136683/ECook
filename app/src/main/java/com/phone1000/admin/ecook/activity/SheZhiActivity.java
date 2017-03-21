package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.utils.DataCleanManager;
import com.phone1000.admin.ecook.utils.LoginUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 用户设置界面
 */

public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener{

    @ViewInject(R.id.exit)
    private LinearLayout exit;
    @ViewInject(R.id.back)
    private ImageButton back;
    @ViewInject(R.id.cache)
    private TextView cache;
    @ViewInject(R.id.clean_cache)
    private LinearLayout clean_cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        x.view().inject(this);
        try {
            cache.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
        clean_cache.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.exit:
                LoginUtils.outLogin(this);
                break;
            case R.id.clean_cache:
                DataCleanManager.clearAllCache(this);
                try {
                    cache.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(this, "删除缓存成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
