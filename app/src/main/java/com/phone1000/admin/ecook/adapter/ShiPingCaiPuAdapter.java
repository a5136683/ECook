package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.ShiPingCaiPuDataInfo;

import org.xutils.x;

import java.util.List;
/**
 * Created by Administrator on 2016/11/15.
 */

public class ShiPingCaiPuAdapter extends BaseAdapter{
    private List<ShiPingCaiPuDataInfo.ListBean> list=null;
    private Context contex=null;


    public ShiPingCaiPuAdapter(List<ShiPingCaiPuDataInfo.ListBean> list, Context contex) {
        this.list = list;
        this.contex = contex;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v=null;
        ViewHolder holder=null;
        if (view==null){
            v= LayoutInflater.from(contex).inflate(R.layout.shiping_caipu_layout,viewGroup,false);
            holder=new ViewHolder();
            holder.shipin_caipu_iv= (ImageView) v.findViewById(R.id.shipin_caipu_iv);
            holder.txtshiping_caipu_zan= (TextView) v.findViewById(R.id.txtshiping_caipu_zan);
            holder.txtshiping_caipu_xing= (TextView) v.findViewById(R.id.txtshiping_caipu_xing);
            holder.txt_Name= (TextView) v.findViewById(R.id.txt_Name);

            v.setTag(holder);
        }else {
            v=view;
            holder= (ViewHolder) v.getTag();
        }
        holder.txt_Name.setText("测试");
        holder.txt_Name.setText(list.get(position).getName());
        holder.txtshiping_caipu_zan.setText(list.get(position).getLikeCount());
        holder.txtshiping_caipu_xing.setText(list.get(position).getCollectCount());
        x.image().bind(holder.shipin_caipu_iv,"http://pic.ecook.cn/web/"+list.get(position).getImageid()+".jpg");
        Log.d("test","http://pic.ecook.cn/web/"+list.get(position).getImageid()+".jpg");
        return v;
    }
    class  ViewHolder{
     ImageView shipin_caipu_iv;
        TextView txtshiping_caipu_zan,txtshiping_caipu_xing,txt_Name;
    }
}
