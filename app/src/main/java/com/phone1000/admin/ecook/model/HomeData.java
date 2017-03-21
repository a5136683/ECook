package com.phone1000.admin.ecook.model;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;
import com.phone1000.admin.ecook.presenter.IHomePresenter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;


/**
 * Created by admin on 2016/11/11.
 */

public class HomeData implements IHomeData {
    private IHomePresenter iHomePresenter;
//

    public HomeData(IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public void getData() {
        String url = "http://api.ecook.cn/public/getDifferentHomedata.shtml";
        RequestParams entity = new RequestParams(url);
        entity.addBodyParameter("machine", "O5f4a734fdc4008ddc289d77fa18a74be8fd41a77");
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeDataInfo homeDataInfo = gson.fromJson(result, HomeDataInfo.class);
                List<HomeDataInfo.DataBean.BannerListBean> bannerList = homeDataInfo.getData().getBannerList();
                List<HomeDataInfo.DataBean.RecommendUserListBean> recommendUserList = homeDataInfo.getData().getRecommendUserList();
                iHomePresenter.setDataAll(homeDataInfo);
                iHomePresenter.setData(recommendUserList);//给presenter发送数据
                iHomePresenter.setHeadViewPagerData(bannerList);
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
    public void getListData(String ids) {

        String url = "http://api.ecook.cn/public/getDifferentdataList.shtml";
        RequestParams entity = new RequestParams(url);
        entity.addBodyParameter("machine", "88b83009675252eea014a8216bcfa7be");
        entity.addBodyParameter("ids", ids);

        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeListDataInfo homeListDataInfo = gson.fromJson(result, HomeListDataInfo.class);
                iHomePresenter.setListData(homeListDataInfo);
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
    public void getListItemUrlData() {

    }
}
