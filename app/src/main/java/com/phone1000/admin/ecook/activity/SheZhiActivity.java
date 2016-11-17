package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.utils.LoginUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener{

    @ViewInject(R.id.exit)
    private LinearLayout exit;
    @ViewInject(R.id.back)
    private ImageButton back;
    @ViewInject(R.id.cache)
    private TextView cache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);

        x.view().inject(this);

        File cacheDir = getCacheDir();
        long totalSpace = cacheDir.getTotalSpace();
        Toast.makeText(this, (int)totalSpace+"", Toast.LENGTH_SHORT).show();


        setListener();
    }

    private void setListener() {
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.exit:
                LoginUtils.outLogin(this);
                break;
        }

    }
}
