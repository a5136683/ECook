package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;

import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/12.
 */

public class HomeItemFootAdapter extends BaseAdapter {
    private Context context = null;
    private List<HomeItemDataInfo.ListBean.StepListBean> list = null;

    public HomeItemFootAdapter(List<HomeItemDataInfo.ListBean.StepListBean> list, Context context) {
        this.context = context;
        this.list = list;
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
        ViewHolder holder = null;
        if(view == null){
            v = LayoutInflater.from(context).inflate(R.layout.home_item_foot_item,viewGroup,false);
            holder = new ViewHolder();
//
//            holder.orderNum = (TextView) v.findViewById(R.id.orderNum);
//            holder.iv = (ImageView) v.findViewById(R.id.home_item_foot_iv);
//            holder.txt = (TextView) v.findViewById(R.id.home_item_foot_txt);

            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }

        holder.orderNum.setText(list.get(i).getOrdernum()+"");
        holder.txt.setText(list.get(i).getDetails());
        x.image().bind(holder.iv,"http://pic.ecook.cn/web/"+list.get(i).getImageid()+".jpg");
        return v;
    }
    class ViewHolder{
        TextView orderNum,txt;
        ImageView iv;
    }
}
