package com.phone1000.admin.ecook.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by james on 16/9/27.
 */
public class NetworkUtils {

    /**
     *  判断网络是否可用
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context){
        boolean flag = false;

        //  构建连接管理对象，当网络发生改变是可以通知应用程序
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null){
            flag = networkInfo.isAvailable();
        }

        return flag;
    }

    /**
     *  判断当前设备WIFI是否可用
     * @param context
     * @return
     */
    public static boolean isWIFIAvailable(Context context){
        boolean flag = false;

        //  构建连接管理对象，当网络发生改变是可以通知应用程序
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(networkInfo  != null && networkInfo.isConnected()){
            flag = true;
    }

        return flag;
    }

    /**
     *  判断当前设备自身是否可用
     * @param context
     * @return
     */
    public static boolean isMobileAvailable(Context context){
        boolean flag = false;

        //  构建连接管理对象，当网络发生改变是可以通知应用程序
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if(networkInfo  != null && networkInfo.isConnected()){
            flag = true;
        }

        return flag;
    }

    /**
     *  获取当前设备的连接状态WIFI，Mobile， BlueTooth
     * @param context
     * @return
     */
    public int getNetworkType(Context context){
        int type = -1;

        //  构建连接管理对象，当网络发生改变是可以通知应用程序
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null){
            type = networkInfo.getType();
        }

        return type;
    }
}
