package com.phone1000.admin.ecook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class xianXiaAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List  txtTitle;

    public xianXiaAdapter(FragmentManager fm, List<Fragment> fragmentList, List txtTitle) {
        super(fm);
        this.fragmentList = fragmentList;
        this.txtTitle = txtTitle;
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return txtTitle.get(position).toString();
    }
}
