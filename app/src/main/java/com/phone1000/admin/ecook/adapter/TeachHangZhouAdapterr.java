package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.TeachFragmentBean.TeachHangZhouDataInfo;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class TeachHangZhouAdapterr extends BaseAdapter {
    private List<TeachHangZhouDataInfo.ListBean> list=null;
    private Context context=null;
    public TeachHangZhouAdapterr(List<TeachHangZhouDataInfo.ListBean> list, Context context) {
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
        View v=null;
        ViewHodler hodler=null;
        if (convertView==null){
            v = LayoutInflater.from(context).inflate(R.layout.teach_all2_item,parent,false);
            hodler=new ViewHodler();

            hodler.teach_all_iv = (ImageView) v.findViewById(R.id.teach_all_iv);
            hodler.teach_all_roomName= (TextView) v.findViewById(R.id.teach_all_roomName);
            hodler.teach_all_address= (TextView) v.findViewById(R.id.teach_all_address);
            hodler.teach_all_title = (TextView) v.findViewById(R.id.teach_all_title);
            hodler.teach_all_txtkcoin = (TextView) v.findViewById(R.id.teach_all_txtkcoin);
            hodler.teach_all_originPrice = (TextView) v.findViewById(R.id.teach_all_originPrice);

            v.setTag(hodler);
        }else {
            v=convertView;
           hodler= (ViewHodler) v.getTag();
            hodler.teach_all_title.setText(list.get(position).getTitle());
            hodler.teach_all_roomName.setText(list.get(position).getRoomName());
            hodler.teach_all_address.setText(list.get(position).getAddress());
            hodler.teach_all_txtkcoin.setText("学费： "+list.get(position).getKcoin()+"厨币"+"+"+"￥"+list.get(position).getPrice());
            hodler.teach_all_originPrice.setText("原价:"+"￥"+list.get(position).getOriginPrice());
            x.image().bind(hodler.teach_all_iv,"http://pic.ecook.cn/web/"+list.get(position).getHimg()+".jpg");
        }
        return v;
    }
    class ViewHodler{
        ImageView teach_all_iv;
        TextView teach_all_title,teach_all_roomName,teach_all_address,teach_all_txtkcoin,teach_all_originPrice;
    }
}
