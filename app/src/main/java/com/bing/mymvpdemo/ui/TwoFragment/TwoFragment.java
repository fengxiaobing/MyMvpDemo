package com.bing.mymvpdemo.ui.TwoFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseFragment;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class TwoFragment extends BaseFragment implements TwoMvpView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);



        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}