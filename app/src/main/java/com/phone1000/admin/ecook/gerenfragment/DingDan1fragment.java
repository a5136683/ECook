package com.phone1000.admin.ecook.gerenfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phone1000.admin.ecook.R;

/**
 * Created by Administrator on 2016/11/15.
 */

public class DingDan1fragment extends Fragment {
    private  View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.gdingdan1_fragment,container,false);
        return v;

    }
}
