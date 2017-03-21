package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.TimeDataInfo;

import org.xutils.x;

import java.util.List;


/**
 * Created by admin on 2016/11/28.
 */

public class TimeAdapter extends BaseAdapter {

    private Context context;
    private List<TimeDataInfo.DataBean.ListBean> list ;

    public TimeAdapter(Context context, List<TimeDataInfo.DataBean.ListBean> list) {
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
            v = LayoutInflater.from(context).inflate(R.layout.time_item,viewGroup,false);
            holder = new ViewHolder();

            holder.point = (ImageView) v.findViewById(R.id.point);
            holder.time_iv= (ImageView) v.findViewById(R.id.time_iv);
            holder.state = (TextView) v.findViewById(R.id.state);
            holder.time_limit = (TextView) v.findViewById(R.id.time_limit);
            holder.title = (TextView) v.findViewById(R.id.title);

            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }

        x.image().bind(holder.time_iv,"http://pic.ecook.cn/web/"+list.get(i).getImage()+".jpg");
        holder.title.setText(list.get(i).getTitle());
        holder.time_limit.setText(list.get(i).getStartTime().split(" ")[0]+"至"+list.get(i).getEndTime().split(" ")[0]);
        if(list.get(i).getIsEnd()==3){
        holder.state.setText("已结束");}else{
            holder.state.setText("进行中");
            holder.point.setImageResource(R.drawable.green_point);
        }

        return v;
    }
    class ViewHolder{
        ImageView time_iv,point;
        TextView time_limit,title,state;
    }
}
