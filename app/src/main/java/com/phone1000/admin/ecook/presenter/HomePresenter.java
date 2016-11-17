package com.phone1000.admin.ecook.presenter;

import android.util.Log;

import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;
import com.phone1000.admin.ecook.model.HomeData;
import com.phone1000.admin.ecook.model.IHomeData;
import com.phone1000.admin.ecook.view.IHomeVIew;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomePresenter implements IHomePresenter {
    private IHomeData iHomeData = new HomeData(this);//取得model
    private IHomeVIew iHomeView = null;


    public HomePresenter(IHomeVIew iHomeView) {
        this.iHomeView = iHomeView;
    }

    @Override
    public void getData() {
        Log.d("test","到达p层了");
        iHomeData.getData();//得到数据
    }
    /**
     * 得到从model层发送过来的数据
     * @param list
     */
    @Override
    public void setData(List<HomeDataInfo.DataBean.RecommendUserListBean> list) {

        iHomeView.getData(list);
    }

    @Override
    public void setHeadViewPagerData(List<HomeDataInfo.DataBean.BannerListBean> list) {
        Log.d("test","从m层拿到数据了");
        iHomeView.getHeadViewPagerData(list);
    }

    @Override
    public void setDataAll(HomeDataInfo homeDataInfo) {
        iHomeView.getDataAll(homeDataInfo);
    }

    @Override
    public void setListData(HomeListDataInfo homeListDataInfo) {
        iHomeView.getListData(homeListDataInfo);
    }

    @Override
    public void getListData(String ids) {
        iHomeData.getListData(ids);
    }


}
