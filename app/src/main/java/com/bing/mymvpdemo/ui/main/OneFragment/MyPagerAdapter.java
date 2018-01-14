package com.bing.mymvpdemo.ui.main.OneFragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */

public class MyPagerAdapter extends PagerAdapter{
    private List<String> mList;
    private List<ImageView> imageViewList;
    private Context context;

    public MyPagerAdapter(Context context,List<String> mList) {
        this.mList = mList;
        this.context = context;
        imageViewList = new ArrayList<>();
    }

    @Override
        public int getCount() {
            //返回一个比较大的值，目的是为了实现无限轮播
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position%mList.size();
            ImageView imageView = new ImageView(context);
            Glide.with(context).load(mList.get(position)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            imageViewList.add(imageView);
            final int finalPosition = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "weizhi"+finalPosition, Toast.LENGTH_SHORT).show();
                }
            });
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            position = position%mList.size();
            container.removeView(imageViewList.get(position));
        }
}
