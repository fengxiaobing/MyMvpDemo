package com.bing.mymvpdemo.ui.main.TwoFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseFragment;
import com.bing.mymvpdemo.ui.main.OneFragment.OneMvpView;
import com.bing.mymvpdemo.ui.main.OneFragment.OnePresenter;
import com.bing.mymvpdemo.ui.main.TwoFragment.TestDialog.TestDialog;
import com.bing.mymvpdemo.ui.widget.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class TwoFragment extends BaseFragment implements TwoMvpView {

    private TwoPresenter<TwoMvpView> twoMvpViewTwoPresenter;
    @BindView(R.id.iv_icon)
    RoundedImageView iv_icon;


    public static TwoFragment newInstance() {
        Bundle args = new Bundle();
        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        twoMvpViewTwoPresenter = new TwoPresenter<>();
        twoMvpViewTwoPresenter.onAttach(this);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {

        twoMvpViewTwoPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        twoMvpViewTwoPresenter.onDetach();

    }

    @OnClick(R.id.iv_icon)
    public void onViewClicked() {
        twoMvpViewTwoPresenter.onDialogShowClick();
    }

    @Override
    public void showTestDialog() {
        TestDialog.newInstance().show(getFragmentManager());
    }
}
