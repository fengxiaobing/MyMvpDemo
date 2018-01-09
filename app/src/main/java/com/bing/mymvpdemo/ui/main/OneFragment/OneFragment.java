package com.bing.mymvpdemo.ui.main.OneFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class OneFragment extends BaseFragment implements OneMvpView {

    private OnePresenter<OneMvpView> oneMvpViewOnePresenter;
    private LinearLayoutManager mLayoutManager;
    private OneAdapter mOneAdapter;
    @BindView(R.id.one_recycler_view)
    RecyclerView mRecyclerView;

    public static OneFragment newInstance() {
        Bundle args = new Bundle();
        OneFragment fragment = new OneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        oneMvpViewOnePresenter = new OnePresenter<>();
        oneMvpViewOnePresenter.onAttach(this);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {

        mLayoutManager = new LinearLayoutManager(getActivity());
        List<Whether> weather = new ArrayList<>();
        mOneAdapter = new OneAdapter(weather);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mOneAdapter);

        oneMvpViewOnePresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        oneMvpViewOnePresenter.onDetach();
        super.onDestroyView();
    }


    @Override
    public void updateData(List<Whether> weather) {
        mOneAdapter.addItems(weather);
    }
}
