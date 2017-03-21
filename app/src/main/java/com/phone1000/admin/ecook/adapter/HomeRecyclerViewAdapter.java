package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.utils.CircleImageView;
import com.phone1000.admin.ecook.view.PersonActivity;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewHolder> {

    private List<HomeDataInfo.DataBean.RecommendUserListBean> list = null;
    private Context context = null;
    private ImageOptions options = null;
    private Intent intent = new Intent();

    public HomeRecyclerViewAdapter(List<HomeDataInfo.DataBean.RecommendUserListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.home_rv_item,parent,false);
        return new HomeRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(context, PersonActivity.class);
                intent.putExtra("Uid",list.get(position).getUid());
                context.startActivity(intent);
            }
        });
        options = new ImageOptions.Builder()
                .setFailureDrawableId(R.mipmap.head_image_weman)
                .setLoadingDrawableId(R.mipmap.head_image_weman)
                .setCircular(true).build();
        holder.home_rv_item_title.setText(list.get(position).getTitle());
        holder.home_rv_item_profile.setText(list.get(position).getProfile());
        String url = "http://pic.ecook.cn/web/" + list.get(position).getImageid() + ".jpg";
        x.image().bind(holder.home_rv_item_iv,url,options);
    }

    @Override
    public int getItemCount() {
        return list==null ? 0 : list.size();
    }
}
class HomeRecyclerViewHolder extends RecyclerView.ViewHolder{

    CircleImageView home_rv_item_iv;
    TextView home_rv_item_title,home_rv_item_profile;

    public HomeRecyclerViewHolder(View itemView) {
        super(itemView);
        home_rv_item_iv = (CircleImageView) itemView.findViewById(R.id.home_rv_item_iv);
        home_rv_item_title = (TextView) itemView.findViewById(R.id.home_rv_item_title);
        home_rv_item_profile = (TextView) itemView.findViewById(R.id.home_rv_item_profile);
    }
}