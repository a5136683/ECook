package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import org.xutils.image.ImageOptions;

import java.util.List;

/**
 * Created by admin on 2016/11/10.
 */

public class PlazaContentAdapter extends BaseAdapter {
    private List<ImageView> list = null;
    private Context context = null;
    private ImageOptions options = null;

    public PlazaContentAdapter(List<ImageView> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;
        return null;
    }
    class ViewHolder{
//        ImageView
    }
}