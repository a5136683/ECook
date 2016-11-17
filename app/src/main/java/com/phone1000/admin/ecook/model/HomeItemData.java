package com.phone1000.admin.ecook.model;

import android.util.Log;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;
import com.phone1000.admin.ecook.presenter.IHomeItemPresenter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeItemData implements IHomeItemData{

    private String url = null;
    private IHomeItemPresenter iHomeItemPresenter = null;

    public HomeItemData(IHomeItemPresenter iHomeItemPresenter) {
        this.iHomeItemPresenter = iHomeItemPresenter;
    }

    @Override
    public void getItemUrl(String url) {
        this.url = url;//从view获取数据成功
        Log.d("test",url+"这是url");
        RequestParams entity = new RequestParams(url);
//        entity.addBodyParameter("machine","O5f4a734fdc4008ddc289d77fa18a74be8fd41a77");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeItemDataInfo homeItemDataInfo = gson.fromJson(result, HomeItemDataInfo.class);
                iHomeItemPresenter.getItemData(homeItemDataInfo);
                Log.d("test","数据获取成功");

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void getItem2Url(String url) {
        this.url = url;//从view获取数据成功
        Log.d("test",url+"这是url");
        RequestParams entity = new RequestParams(url);
//        entity.addBodyParameter("machine","O5f4a734fdc4008ddc289d77fa18a74be8fd41a77");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeItem2DataInfo homeItem2DataInfo = gson.fromJson(result, HomeItem2DataInfo.class);
                iHomeItemPresenter.getItem2Data(homeItem2DataInfo);
                Log.d("test","数据获取成功");

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
