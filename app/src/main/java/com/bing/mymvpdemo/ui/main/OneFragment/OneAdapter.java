package com.bing.mymvpdemo.ui.main.OneFragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RF
 * on 2018/1/9.
 */

public class OneAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<Whether> weatherBeanList;

    public OneAdapter(List<Whether> weatherBeanList) {
        this.weatherBeanList = weatherBeanList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one_view, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return weatherBeanList.size();
    }

    public void addItems(List<Whether> weather) {
        weatherBeanList.addAll(weather);
        notifyDataSetChanged();
    }
    public void refreshItems(List<Whether> weather) {
        weatherBeanList.clear();
        weatherBeanList.addAll(weather);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.title_text_view)
        TextView titleTextView;

        @BindView(R.id.author_text_view)
        TextView authorTextView;

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        @BindView(R.id.content_text_view)
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");
            contentTextView.setText("");
        }

        public void onBind(final int position) {
            super.onBind(position);

            final Whether weatherBean = weatherBeanList.get(position);

            String imageUrl = "http://img2.imgtn.bdimg.com/it/u=620183094,2744897300&fm=27&gp=0.jpg";
            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .asBitmap()
                    .centerCrop()
                    .into(coverImageView);


            if (weatherBean != null) {
                titleTextView.setText(weatherBean.getText());
            }

            if (weatherBean.getTime() != null) {
                authorTextView.setText(weatherBean.getTime());
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "啦啦啦啦"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
