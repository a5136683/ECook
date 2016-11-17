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
import com.phone1000.admin.ecook.bean.Talk;
import com.phone1000.admin.ecook.utils.CircleImageView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

import static com.phone1000.admin.ecook.R.id.plaza_head_iv;

/**
 * Created by admin on 2016/11/9.
 */

public class PlazaAdapter extends BaseAdapter {

    private List<Talk.ListBean> list = null;
    private Context context = null;
    private ImageOptions options = null;
    private ImageOptions options1 = null;
    private String[] split = null;
    private String imageids = null;
    private ImageView imageView = null;
    private int k = 0;
    private View v = null;
    private ViewHolder holder = null;
    private Intent intent = new Intent();

    public PlazaAdapter(List<Talk.ListBean> list, Context context) {
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
        options = new ImageOptions.Builder()
                .setFailureDrawableId(R.mipmap.head_image_weman)
                .setLoadingDrawableId(R.mipmap.head_image_weman)
                .setCircular(true)
                .build();

//        if (view == null) {
        v = LayoutInflater.from(context).inflate(R.layout.talk_plaza_list_item, viewGroup, false);
        holder = new ViewHolder();
        holder.plaza_title = (TextView) v.findViewById(R.id.plaza_title);
        holder.plaza_head_iv = (CircleImageView) v.findViewById(plaza_head_iv);
        holder.plaza_content = (TextView) v.findViewById(R.id.plaza_content);
        holder.plaza_time = (TextView) v.findViewById(R.id.plaza_time);
        holder.plaza_image1 = (ImageView) v.findViewById(R.id.plaza_image1);
        holder.plaza_image2 = (ImageView) v.findViewById(R.id.plaza_image2);
        holder.plaza_image3 = (ImageView) v.findViewById(R.id.plaza_image3);
//            v.setTag(holder);
//        }
//        else {
//            v = view;
//            holder = (ViewHolder) v.getTag();
//        }
        holder.plaza_title.setText(list.get(i).getUsername());
        holder.plaza_time.setText(list.get(i).getDisplaytime());
        holder.plaza_content.setText(list.get(i).getText());
        String imageUrl = "http://pic.ecook.cn/web/" + list.get(i).getUserimageid().toString() + ".jpg!s1";
        x.image().bind(holder.plaza_head_iv, imageUrl, options);
        imageids = list.get(i).getImageids();
        split = imageids.split("\\,");//得到图片id的数组
        if (split.length == 1) {
            String url = "http://pic.ecook.cn/web/" + split[0] + ".jpg";
            x.image().bind(holder.plaza_image1, url);
            holder.plaza_image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else if (split.length == 2) {
            String url = "http://pic.ecook.cn/web/" + split[0] + ".jpg";
            x.image().bind(holder.plaza_image1, url);
            String url2 = "http://pic.ecook.cn/web/" + split[1] + ".jpg";
            x.image().bind(holder.plaza_image2, url2);
        } else {
            String url = "http://pic.ecook.cn/web/" + split[0] + ".jpg";
            x.image().bind(holder.plaza_image1, url);
            String url2 = "http://pic.ecook.cn/web/" + split[1] + ".jpg";
            x.image().bind(holder.plaza_image2, url2);
            String url3 = "http://pic.ecook.cn/web/" + split[2] + ".jpg";
            x.image().bind(holder.plaza_image3, url3);
        }
//        holder.plaza_image1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent.setClass(context, PictureActivity.class);
//                intent.putExtra("image",split);
//                context.startActivity(intent);
//            }
//        });
//        holder.plaza_image2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent.setClass(context, PictureActivity.class);
//                intent.putExtra("image",split);
//                context.startActivity(intent);
//            }
//        });
//        holder.plaza_image3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent.setClass(context, PictureActivity.class);
//                intent.putExtra("image",split);
//                context.startActivity(intent);
//            }
//        });
        return v;
    }
//        options1 =new ImageOptions.Builder()
//                .setRadius(8)
//                .build();
//        for (int j = 0; j < split.length ; j++) {
//            final String url = "http://pic.ecook.cn/web/" + split[j] + ".jpg";
//            ImageView imageView = new ImageView(context);
//            int measuredWidth = holder.plaza_gridView.getMeasuredWidth();
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth/3,measuredWidth/3));
//            imageView.setPadding(4,4,4,4);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            x.image().bind(imageView, url,options1);
//            k++;
//            holder.plaza_gridView.addView(imageView);
//            Log.d("test","+++++++++++++++++++"+k);
//        }
//            holder.plaza_gridView.setColumnCount(3);


    class ViewHolder {
        CircleImageView plaza_head_iv;
        TextView plaza_title, plaza_time, plaza_content;
        ImageView plaza_image2, plaza_image1, plaza_image3;
    }

}
