package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeDataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeHeadAdapter extends PagerAdapter {

    private List<HomeDataInfo.DataBean.BannerListBean> list = null;
    private Context context = null;
    private ImageOptions options;

    public HomeHeadAdapter(List<HomeDataInfo.DataBean.BannerListBean> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        options = new ImageOptions.Builder()
                .setFailureDrawableId(R.mipmap.earn_coin_default)
                .setLoadingDrawableId(R.mipmap.earn_coin_default)
                .build();
        x.image().bind(imageView,"http://pic.ecook.cn/web/" +list.get(position).getImage()+".jpg",options);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
