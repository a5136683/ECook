package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/12.
 */

public class HomeItemAdapter extends BaseAdapter {

    private Context context = null;
    private List<HomeItemDataInfo.ListBean.MaterialListBean> list = null;

    public HomeItemAdapter(List<HomeItemDataInfo.ListBean.MaterialListBean> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
        ViewHolder holder = null;
        if (view == null) {
            v = LayoutInflater.from(context).inflate(R.layout.single_text, viewGroup, false);
            if (i % 2 == 0) {
                v.setBackgroundColor(Color.rgb(238, 238, 238));
            }
            holder = new ViewHolder();

            holder.txt1 = (TextView) v.findViewById(R.id.single_text);
            holder.txt2 = (TextView) v.findViewById(R.id.single_text2);

            v.setTag(holder);
        } else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        holder.txt2.setText(list.get(i).getDosage());
        holder.txt1.setText(list.get(i).getName());
        return v;
    }

    class ViewHolder {
        TextView txt1;
        TextView txt2;
    }
}