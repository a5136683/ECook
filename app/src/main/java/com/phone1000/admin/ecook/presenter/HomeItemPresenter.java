package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;
import com.phone1000.admin.ecook.model.HomeItemData;
import com.phone1000.admin.ecook.model.IHomeItemData;
import com.phone1000.admin.ecook.view.IHomeItemView;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeItemPresenter implements IHomeItemPresenter {

    private IHomeItemData iHomeItemData = new HomeItemData(this);
    private IHomeItemView iHomeItemView = null;

    public HomeItemPresenter(IHomeItemView iHomeItemView) {
        this.iHomeItemView = iHomeItemView;
    }

    @Override
    public void getItemUrl(String url) {
        iHomeItemData.getItemUrl(url);
    }

    @Override
    public void getItem2Url(String url) {
        iHomeItemData.getItem2Url(url);
    }

    @Override
    public void getItemData(HomeItemDataInfo homeItemDataInfo){
        iHomeItemView.getItemData(homeItemDataInfo);
    }

    @Override
    public void getItem2Data(HomeItem2DataInfo homeItem2DataInfo) {
        iHomeItemView.getItem2Data(homeItem2DataInfo);
    }
}
