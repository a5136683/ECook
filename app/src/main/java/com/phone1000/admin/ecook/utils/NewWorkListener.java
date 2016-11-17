package com.phone1000.admin.ecook.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by admin on 2016/11/15.
 */

public class NewWorkListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(NetworkUtils.isNetworkAvailable(context)){
            Toast.makeText(context, "当前网络可用", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "网络异常，请检查网络是否连接", Toast.LENGTH_SHORT).show();
        }
    }
}
