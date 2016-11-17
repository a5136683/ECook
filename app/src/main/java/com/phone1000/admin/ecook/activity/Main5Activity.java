package com.phone1000.admin.ecook.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.adapter.ShouCangAdapter;
import com.phone1000.admin.ecook.fragment.gerenfragment.DingDan1fragment;
import com.phone1000.admin.ecook.fragment.gerenfragment.DingDan2fragment;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    private View v;
    private TabLayout shoucang_tabLayout;
    private ViewPager shoucang_ViewPager;
    private List<Fragment> fragmentList;
    private List txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
        setData();
        Select();
    }
    private void Select() {
        shoucang_ViewPager.setAdapter(new ShouCangAdapter(getSupportFragmentManager(),fragmentList,txtTitle));
        shoucang_tabLayout.setTabTextColors(Color.BLACK,Color.rgb(255,192,0));
        shoucang_tabLayout.setSelectedTabIndicatorColor(Color.rgb(255,192,0));
        shoucang_tabLayout.setTabMode(TabLayout.MODE_FIXED);
        shoucang_tabLayout.setupWithViewPager(shoucang_ViewPager);
    }

    private void setData() {
        fragmentList=new ArrayList<>();

        fragmentList.add(new DingDan1fragment());
        fragmentList.add(new DingDan2fragment());

        txtTitle=new ArrayList();
        txtTitle.add("未完成");
        txtTitle.add("已完成");
    }

    private void initView() {
        shoucang_tabLayout= (TabLayout) findViewById(R.id.shoucang_tabLayout);
        shoucang_ViewPager= (ViewPager) findViewById(R.id.shoucang_ViewPager);
    }
    public void onClick(View view) {
        finish();
    }
}
