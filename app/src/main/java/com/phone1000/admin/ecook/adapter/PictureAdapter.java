package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.image.ImageOptions;

import java.util.List;

/**
 * Created by admin on 2016/11/14.
 */

public class PictureAdapter extends PagerAdapter {

    private List<ImageView> url = null;
    private Context context = null;
    private ImageOptions options = null;

    public PictureAdapter(List<ImageView> url, Context context) {
        this.url = url;
        this.context = context;
    }

    @Override
    public int getCount() {
        return url.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(url.get(position));
        return url.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
