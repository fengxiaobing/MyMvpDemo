package com.bing.mymvpdemo.ui.main.FourFragment;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseFragment;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class FourFragment extends BaseFragment implements FourMvpView {
    @BindView(R.id.imageView)
    ImageView imageView;
    FourMvpPresenter<FourMvpView> fourMvpViewFourMvpPresenter;
    public static FourFragment newInstance() {
        Bundle args = new Bundle();
        FourFragment fragment = new FourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        fourMvpViewFourMvpPresenter = new FourPresenter<>();
        fourMvpViewFourMvpPresenter.onAttach(this);
         ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {
        fourMvpViewFourMvpPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fourMvpViewFourMvpPresenter.onDetachCancleNetWork();
    }

    @Override
    public void showAnimal() {
        //开启动画
//        Drawable drawable = imageView.getDrawable();
//        if (drawable instanceof Animatable) {
//            ((Animatable) drawable).start();
//        }

        String imageUrl = "http://img2.imgtn.bdimg.com/it/u=620183094,2744897300&fm=27&gp=0.jpg";
        //网络加载图片
        Glide.with(getActivity())
                .load(imageUrl)
                .into(imageView);

    }
}
