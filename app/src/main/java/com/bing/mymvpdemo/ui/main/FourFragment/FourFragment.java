package com.bing.mymvpdemo.ui.main.FourFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseFragment;
import com.bing.mymvpdemo.ui.main.ThreeFragment.ThreeFragment;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class FourFragment extends BaseFragment implements FourMvpView {
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



        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
