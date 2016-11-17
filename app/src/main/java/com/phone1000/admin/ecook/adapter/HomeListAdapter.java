package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeListAdapter extends BaseAdapter {
    private List<HomeListDataInfo.ListBean> list = null;
    private Context context = null;
    private ImageOptions options = null;
    private int flag = 0;

    public HomeListAdapter(List<HomeListDataInfo.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
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
//        if (view == null) {
        //四种不同的布局 在下面如果重用当前布局的话，会造成布局于内容不匹配的问题，所以没有采用ViewHolder进行优化
            if (list.get(i).getType() == 1) {
            v = LayoutInflater.from(context).inflate(R.layout.home_list_item1, viewGroup, false);
            holder = new ViewHolder();
            holder.home_list_iv = (ImageView) v.findViewById(R.id.home_list_iv);
            holder.home_list_name = (TextView) v.findViewById(R.id.home_list_name);
            holder.home_list_title = (TextView) v.findViewById(R.id.home_list_title);
            holder.home_list_content = (TextView) v.findViewById(R.id.home_list_content);
            holder.home_list_user = (ImageView) v.findViewById(R.id.home_list_user);
            holder.home_list_iv_collection = (TextView) v.findViewById(R.id.home_list_iv_collection);
            holder.home_list_iv_parise = (TextView) v.findViewById(R.id.home_list_iv_parise);
            flag = 1;
            v.setTag(holder);
        } else if (list.get(i).getType() == 2) {
            v = LayoutInflater.from(context).inflate(R.layout.home_list_item2, viewGroup, false);
            holder = new ViewHolder();
            holder.home_list_iv = (ImageView) v.findViewById(R.id.home_list_iv);
            holder.home_list_name = (TextView) v.findViewById(R.id.home_list_name);
            holder.home_list_title = (TextView) v.findViewById(R.id.home_list_title);
            holder.home_list_content = (TextView) v.findViewById(R.id.home_list_content);
            holder.home_list_user = (ImageView) v.findViewById(R.id.home_list_user);
            flag = 2;
            v.setTag(holder);
        } else if (list.get(i).getType() == 3) {//存在视频
            v = LayoutInflater.from(context).inflate(R.layout.home_list_item3, viewGroup, false);
            holder = new ViewHolder();
            holder.home_list_user = (ImageView) v.findViewById(R.id.home_list_user);
            holder.home_list_iv = (ImageView) v.findViewById(R.id.home_list_iv);
            holder.home_list_name = (TextView) v.findViewById(R.id.home_list_name);
            holder.home_list_title = (TextView) v.findViewById(R.id.home_list_title);
            holder.home_list_content = (TextView) v.findViewById(R.id.home_list_content);
            holder.home_list_iv_show = (ImageView) v.findViewById(R.id.home_list_iv_show);
            holder.home_list_iv_collection = (TextView) v.findViewById(R.id.home_list_iv_collection);
            holder.home_list_iv_parise = (TextView) v.findViewById(R.id.home_list_iv_parise);
            flag = 3;
            v.setTag(holder);
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.home_list_item4, viewGroup, false);
//            holder = new ViewHolder();
//            holder.home_list_iv = (ImageView) v.findViewById(R.id.home_list_iv);
//            holder.home_list_name = (TextView) v.findViewById(R.id.home_list_name);
//            holder.home_list_title = (TextView) v.findViewById(R.id.home_list_title);
//            holder.home_list_content = (TextView) v.findViewById(R.id.home_list_content);
//            holder.home_list_user = (ImageView) v.findViewById(R.id.home_list_user);
            flag = 4;
            v.setTag(holder);
        }
//        }
//        else {
//            v = view;
//            holder = (ViewHolder) v.getTag();
//        }
        options = new ImageOptions.Builder().setFailureDrawableId(R.mipmap.head_image_weman).setLoadingDrawableId(R.mipmap.head_image_weman).setCircular(true).build();


        if (flag == 2) {
            holder.home_list_content.setText(list.get(i).getTotalNum());
        } else if (flag == 1) {
            holder.home_list_content.setText(list.get(i).getDesc());
            if(Integer.toString(list.get(i).getLikeNum())!=null);
            holder.home_list_iv_parise.setText(list.get(i).getLikeNum() + "");
            if(Integer.toString(list.get(i).getLikeNum())!=null);
            holder.home_list_iv_collection.setText(list.get(i).getCollectionNum() + "");
        } else if (flag == 4) {
//            holder.home_list_content.setText(list.get(i).getDesc());
        } else if (flag == 3) {
            holder.home_list_content.setText(list.get(i).getDesc());
            if(list.get(i).getLikeNum()+"" != null)
            holder.home_list_iv_parise.setText(list.get(i).getLikeNum()+"");
            if(list.get(i).getCollectionNum()+"" != null)
            holder.home_list_iv_collection.setText(list.get(i).getLikeNum()+"");
        }
        if(flag != 4) {
            holder.home_list_title.setText(list.get(i).getTitle());
            holder.home_list_name.setText(list.get(i).getUserNick());
            x.image().bind(holder.home_list_iv, "http://pic.ecook.cn/web/" + list.get(i).getImage() + ".jpg");
            x.image().bind(holder.home_list_user, "http://pic.ecook.cn/web/" + list.get(i).getUserImage() + ".jpg", options);
        } return v;
    }

    class ViewHolder {
        ImageView home_list_iv, home_list_user, home_list_iv_show;
        TextView home_list_title, home_list_name, home_list_content, home_list_totalNum, home_list_iv_parise, home_list_iv_collection;
    }
}
