package com.phone1000.admin.ecook.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.view.HomeItemActivity;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/13.
 */

public class HomeList2Adapter extends BaseAdapter{

    private List<HomeItem2DataInfo.DetailsBean.RecipeListBean> list = null;
    private Context context = null;
    private ImageOptions options = null;
    private Intent intent = null;

    public HomeList2Adapter(List<HomeItem2DataInfo.DetailsBean.RecipeListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size()/3;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        options = new ImageOptions.Builder().setRadius(5).setLoadingDrawableId(R.mipmap.collection_modelx).setFailureDrawableId(R.mipmap.collection_modelx).build();
        View v = null;
        ViewHolder holder = null;
        if(view == null){
            v = LayoutInflater.from(context).inflate(R.layout.home_list2_item,viewGroup,false);
            holder = new ViewHolder();

            holder.iv1 = (ImageView) v.findViewById(R.id.item2_iv1);
            holder.txt1 = (TextView) v.findViewById(R.id.item2_txt1);
            holder.iv2= (ImageView) v.findViewById(R.id.item2_iv2);
            holder.txt2 = (TextView) v.findViewById(R.id.item2_txt2);
            holder.iv3 = (ImageView) v.findViewById(R.id.item2_iv3);
            holder.txt3 = (TextView) v.findViewById(R.id.item2_txt3);

            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }

        if(list.get(i*3).getImageid()!=null){
        x.image().bind(holder.iv1,"http://pic.ecook.cn/web/"+list.get(i*3).getImageid()+".jpg",options);
            holder.iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(context, HomeItemActivity.class);
                    intent.putExtra("url","http://api.ecook.cn/public/getRecipeListByIds.shtml?ids="+list.get(i*3).getId());
                    intent.putExtra("imageUrl",list.get(i*3).getAuthorimageid());
                    intent.putExtra("praise", list.get(i*3).getLikeCount());
                    intent.putExtra("collection", list.get(i*3).getCollectCount());
                    context.startActivity(intent);
                }
            });}
        if(list.get(i*3+1).getImageid()!=null){
        x.image().bind(holder.iv2,"http://pic.ecook.cn/web/"+list.get(i*3+1).getImageid()+".jpg",options);
            holder.iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(context, HomeItemActivity.class);
                    intent.putExtra("url","http://api.ecook.cn/public/getRecipeListByIds.shtml?ids="+list.get(i*3+1).getId());
                    intent.putExtra("imageUrl",list.get(i*3+1).getAuthorimageid());
                    intent.putExtra("praise", list.get(i*3+1).getLikeCount());
                    intent.putExtra("collection", list.get(i*3+1).getCollectCount());
                    context.startActivity(intent);
                }
            });}
        if(list.get(i*3+2).getImageid()!=null){
        x.image().bind(holder.iv3,"http://pic.ecook.cn/web/"+list.get(i*3+2).getImageid()+".jpg",options);
            holder.iv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(context, HomeItemActivity.class);
                    intent.putExtra("url","http://api.ecook.cn/public/getRecipeListByIds.shtml?ids="+list.get(i*3+2).getId());
                    intent.putExtra("imageUrl",list.get(i*3+2).getAuthorimageid());
                    intent.putExtra("praise", list.get(i*3+2).getLikeCount());
                    intent.putExtra("collection", list.get(i*3+2).getCollectCount());
                    context.startActivity(intent);
                }
            });}
        if(list.get(i*3).getName()!=null)
        holder.txt1.setText(list.get(i*3).getName());
        if(list.get(i*3+1).getName()!=null)
        holder.txt2.setText(list.get(i*3+1).getName());
        if(list.get(i*3+2).getName()!=null)
        holder.txt3.setText(list.get(i*3+2).getName());

        return v;
    }

    class ViewHolder{
        ImageView iv1,iv2,iv3;
        TextView txt1,txt2,txt3;
    }
}
