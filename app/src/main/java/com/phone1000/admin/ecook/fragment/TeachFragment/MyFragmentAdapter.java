package com.phone1000.admin.ecook.fragment.TeachFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentlist;
    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentlist) {
        super(fm);
        this.fragmentlist=fragmentlist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
