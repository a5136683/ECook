package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;

/**
 * Created by admin on 2016/11/11.
 */

public interface IHomeItemPresenter {
    void getItemUrl(String url);
    void getItem2Url(String url);
    void getItemData(HomeItemDataInfo homeItemDataInfo);
    void getItem2Data(HomeItem2DataInfo homeItem2DataInfo);
}
