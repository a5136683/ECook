package com.phone1000.admin.ecook.TeachFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.BeiJing_fragment;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.GuangZhou_fragment;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.HangZhou_fragment;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.QuanBu_fragment;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.ShangHai_fragment;
import com.phone1000.admin.ecook.Teach_XianXiaFragmnet.ShenZhen_fragment;
import com.phone1000.admin.ecook.adapter.xianXiaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class TeachFragment_XianXia extends Fragment {
    private View v;
    private TabLayout xianXia_tabLayout;
    private ViewPager xianXia_ViewPager;
    private List<Fragment> fragmentList;
    private List txtTitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.teach3_fragment_layout,null);
        initView();
        setData();
        Select();
        return v;
    }

    private void Select() {
        xianXia_ViewPager.setAdapter(new xianXiaAdapter(getChildFragmentManager(),fragmentList,txtTitle));
        xianXia_tabLayout.setTabTextColors(Color.BLACK,Color.rgb(255,192,0));
        xianXia_tabLayout.setSelectedTabIndicatorColor(Color.rgb(255,192,0));
        xianXia_tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        xianXia_tabLayout.setupWithViewPager(xianXia_ViewPager);
    }

    private void setData() {
        fragmentList=new ArrayList<>();

        fragmentList.add(new QuanBu_fragment());
        fragmentList.add(new HangZhou_fragment());
        fragmentList.add(new ShangHai_fragment());
        fragmentList.add(new BeiJing_fragment());
        fragmentList.add(new GuangZhou_fragment());
        fragmentList.add(new ShenZhen_fragment());

        txtTitle=new ArrayList();
        txtTitle.add("全部");
        txtTitle.add("杭州");
        txtTitle.add("上海");
        txtTitle.add("北京");
        txtTitle.add("广州");
        txtTitle.add("深圳");






    }

    private void initView() {
        xianXia_tabLayout= (TabLayout) v.findViewById(R.id.xianXia_tabLayout);
        xianXia_ViewPager= (ViewPager) v.findViewById(R.id.xianXia_ViewPager);
    }

}
