package com.phone1000.admin.ecook.view;

import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public interface IHomeVIew {
    void getData(List<HomeDataInfo.DataBean.RecommendUserListBean> list);
    void getHeadViewPagerData(List<HomeDataInfo.DataBean.BannerListBean> list);
    void getDataAll(HomeDataInfo homeDataInfo);
    void getListData(HomeListDataInfo homeListDataInfo);
}
