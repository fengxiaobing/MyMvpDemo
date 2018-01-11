package com.bing.mymvpdemo.ui.main.OneFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

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

    private OneMvpPresenter<OneMvpView> oneMvpViewOnePresenter;
    private LinearLayoutManager mLayoutManager;
    private OneAdapter mOneAdapter;
    @BindView(R.id.one_recycler_view)
    XRecyclerView mRecyclerView;
    View header;

    private int refreshTime = 0;
    private int times = 0;

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
        header = inflater.inflate(R.layout.recyclerview_header, container, false);

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
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        //注释此段代码将会下拉刷新时没有几分钟前提示
//        mRecyclerView
//                .getDefaultRefreshHeaderView()
//                .setRefreshTimeVisible(false);
        mRecyclerView.addHeaderView(header);

        mRecyclerView.getDefaultFootView().setLoadingHint("自定义加载中提示");
        mRecyclerView.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                times = 0;
                oneMvpViewOnePresenter.onViewPrepared();
//                if(mRecyclerView != null) {
//                    mRecyclerView.refreshComplete();
//                    mRecyclerView.setLoadingMoreEnabled(true);
//                }
            }

            @Override
            public void onLoadMore() {

                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            oneMvpViewOnePresenter.onLoadMoreData();
                            mRecyclerView.loadMoreComplete();
                        }

                    }, 1000);            //refresh data here

                } else {
                    mRecyclerView.setNoMore(true);
                }
                times++;
            }
        });

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
        if(weather != null){
            mOneAdapter.addItems(weather);
        }
        mRecyclerView.refreshComplete();
        mRecyclerView.setLoadingMoreEnabled(true);
    }
}
