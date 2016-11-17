package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.TeachFragmentBean.TeachShiPingDataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ShiPingAdapter extends BaseAdapter {
    private  List<TeachShiPingDataInfo.ListBean> list;
    private Context context;
    private ImageOptions  options=null;

    public ShiPingAdapter(List<TeachShiPingDataInfo.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolder holder=null;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.teach_shiping_item,parent,false);
            holder=new ViewHolder();
            holder.teach_shiping_iv= (ImageView) view.findViewById(R.id.teach_shiping_iv);
            holder.teach_shiping_imageid= (ImageView) view.findViewById(R.id.teach_shiping_imageid);
            holder.teach_shiping_nickname= (TextView) view.findViewById(R.id.teach_shiping_nickname);
            holder.teach_shiping_title= (TextView) view.findViewById(R.id.teach_shiping_title);
            holder.teach_shiping_price= (TextView) view.findViewById(R.id.teach_shiping_price);
            view.setTag(holder);
        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }

        holder.teach_shiping_nickname.setText(list.get(position).getTeacher().getNickname());
        holder.teach_shiping_title.setText(list.get(position).getTitle());
        holder.teach_shiping_price.setText("学费：￥"+list.get(position).getPrice());

        options=new ImageOptions.Builder().setCircular(true).build();
        x.image().bind(holder.teach_shiping_iv,"http://pic.ecook.cn/web/"+list.get(position).getHimg()+".jpg");
        x.image().bind(holder.teach_shiping_imageid,"http://pic.ecook.cn/web/"+list.get(position).getTeacher().getImageid()+".jpg",options);
        return view;
    }
    class  ViewHolder{
        ImageView teach_shiping_iv,teach_shiping_imageid;
        TextView teach_shiping_nickname,teach_shiping_title,teach_shiping_price;
    }
}
