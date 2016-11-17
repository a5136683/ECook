package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.TeachFragmentBean.TeachZhiBODataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ZhiBoAdapter extends BaseAdapter {
    private List<TeachZhiBODataInfo.ListBean> list;
    private Context context;
    private ImageOptions options = null;

    public ZhiBoAdapter(List<TeachZhiBODataInfo.ListBean> list, Context context) {
        this.context = context;
        this.list = list;
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
            view= LayoutInflater.from(context).inflate(R.layout.teach_zhibo_item,parent,false);
            holder=new ViewHolder();
            holder.teach_ZhiBo_iv= (ImageView) view.findViewById(R.id.teach_ZhiBo_iv);
            holder.teach_ZhiBo_imageid= (ImageView) view.findViewById(R.id.teach_ZhiBo_imageid);
            holder.teach_ZhiBo_title= (TextView) view.findViewById(R.id.teach_ZhiBo_title);
            holder.teach_ZhiBo_ecookCoin= (TextView) view.findViewById(R.id.teach_ZhiBo_ecookCoin);
            holder.teach_ZhiBo_time= (TextView) view.findViewById(R.id.teach_ZhiBo_time);
            holder.teach_ZhiBo_nickname= (TextView) view.findViewById(R.id.teach_ZhiBo_nickname);

            view.setTag(holder);
        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        holder.teach_ZhiBo_title.setText("Kankan");

        holder.teach_ZhiBo_title.setText(list.get(position).getTitle());
        holder.teach_ZhiBo_nickname.setText(list.get(position).getTeacher().getNickname());
        holder.teach_ZhiBo_ecookCoin.setText("学费："+list.get(position).getEcookCoin()+"厨币");
        options = new ImageOptions.Builder().setCircular(true).build();
         x.image().bind( holder.teach_ZhiBo_imageid,"http://pic.ecook.cn/web/"+list.get(position).getTeacher().getImageid()+".jpg",options);
         x.image().bind(holder.teach_ZhiBo_iv,"http://pic.ecook.cn/web/"+list.get(position).getHimg()+".jpg");
        return view;
    }
    class ViewHolder{
        ImageView teach_ZhiBo_iv,teach_ZhiBo_imageid;
        TextView teach_ZhiBo_nickname,teach_ZhiBo_title,teach_ZhiBo_ecookCoin,teach_ZhiBo_time;
    }
}
