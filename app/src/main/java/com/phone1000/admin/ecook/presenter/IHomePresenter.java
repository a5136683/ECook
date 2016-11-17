package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public interface IHomePresenter {
    void getData();
    void getListData(String ids);
    void setData(List<HomeDataInfo.DataBean.RecommendUserListBean> list);
    void setHeadViewPagerData(List<HomeDataInfo.DataBean.BannerListBean> list);
    void setDataAll(HomeDataInfo homeDataInfo);
    void setListData(HomeListDataInfo homeListDataInfo);

}
