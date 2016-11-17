package com.phone1000.admin.ecook.fragment.MyFragment;

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
import com.phone1000.admin.ecook.adapter.TalkAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/8.
 */

public class TalkFragment extends Fragment{

    private View v = null;
    private Fragment fragment = null;
    private List<Fragment> fragmentList = null;
    private List titleList = null;
    private TabLayout talk_tabLayout = null;
    private ViewPager talk_ViewPager = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.talk_fragment_layout,container,false);

        initView();

        setData();

        talk_ViewPager.setAdapter(new TalkAdapter(getFragmentManager(),fragmentList,titleList));
        talk_tabLayout.setTabTextColors(Color.BLACK,Color.rgb(255,192,0));
        talk_tabLayout.setSelectedTabIndicatorColor(Color.rgb(255,192,0));
        talk_tabLayout.setTabMode(TabLayout.MODE_FIXED);
        talk_tabLayout.setupWithViewPager(talk_ViewPager);

        return v;
    }


    private void setData() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList();

        fragmentList.add(new TalkFragmentPlaza());
        fragmentList.add(new TalkFragmentAttention());

        titleList.add("广场");
        titleList.add("关注");
    }

    private void initView() {
        talk_tabLayout = (TabLayout) v.findViewById(R.id.talk_tabLayout);
        talk_ViewPager = (ViewPager) v.findViewById(R.id.talk_ViewPager);
    }

//    if(v == null){
//        v = inflater.inflate(R.layout.talk_fragment_layout,container,false);
//
//        fragmentList.add(new TalkFragmentAttention());
//        fragmentList.add(new TalkFragmentPlaza());
//    }
}
