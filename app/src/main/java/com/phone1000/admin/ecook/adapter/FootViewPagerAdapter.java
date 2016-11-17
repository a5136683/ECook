package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/12.
 */

public class FootViewPagerAdapter extends PagerAdapter {

    private List<HomeItemDataInfo.ListBean.StepListBean> list = null;
    private Context context = null;
    private ImageOptions options = null;

    public FootViewPagerAdapter(List<HomeItemDataInfo.ListBean.StepListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        options = new ImageOptions.Builder().setRadius(20).setLoadingDrawableId(R.mipmap.head_image_weman).setFailureDrawableId(R.mipmap.head_image_weman).build();
        Log.d("test","33333333333333333333");
        ImageView imageView = new ImageView(context);
        x.image().bind(imageView,"http://pic.ecook.cn/web/"+list.get(position).getImageid()+".jpg!m720",options);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
