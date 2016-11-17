package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phone1000.admin.ecook.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/9.
 */

public class HeadAdapter<T> extends PagerAdapter {

    private List<T> list = null;
    private Context context = null;
    private ImageOptions options;

    public HeadAdapter(List<T> list,Context context) {
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
                .setFailureDrawableId(R.mipmap.head_image_weman)
                .setLoadingDrawableId(R.mipmap.head_image_weman)
                .build();
        x.image().bind(imageView,(String) list.get(position),options);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
