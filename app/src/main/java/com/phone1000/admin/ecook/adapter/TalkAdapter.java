package com.phone1000.admin.ecook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2016/11/8.
 */

public class TalkAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = null;
    private List titleList = null;

    public TalkAdapter(FragmentManager fm,List<Fragment> fragmentList,List titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position).toString();
    }
}
