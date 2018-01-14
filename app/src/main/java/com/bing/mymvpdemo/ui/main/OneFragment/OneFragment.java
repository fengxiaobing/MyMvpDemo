package com.bing.mymvpdemo.ui.main.OneFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class OneFragment extends BaseFragment implements OneMvpView {

    ViewPager viewpager;
    RadioGroup group;
    private OneMvpPresenter<OneMvpView> oneMvpViewOnePresenter;
    private LinearLayoutManager mLayoutManager;
    private OneAdapter mOneAdapter;
    @BindView(R.id.one_recycler_view)
    XRecyclerView mRecyclerView;
    View header;

    private MyPagerAdapter pagerAdapter;
    private int times = 0;
    //定时器，用于实现轮播
    private Timer timer;
    private TimerTask timerTask;
    //当前索引位置以及上一个索引位置
    private int index = 0, preIndex = 0;
    //是否需要轮播标志
    private boolean isContinue = true;
    private List<String> urls;

    private ScheduledExecutorService scheduledExecutorService;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    index++;
                    viewpager.setCurrentItem(index);
                    break;
            }
            return false;
        }
    });

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
        viewpager = header.findViewById(R.id.viewpager);
        group = header.findViewById(R.id.group);
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
//        mRecyclerView.getDefaultRefreshHeaderView().setRefreshTimeVisible(false);
        mRecyclerView.addHeaderView(header);
        mRecyclerView.getDefaultFootView().setLoadingHint("自定义加载中提示");
        mRecyclerView.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");
        mRecyclerView.setLoadingListener(loadingListener);
        mRecyclerView.setAdapter(mOneAdapter);

        viewpager.setOnTouchListener(onTouchListener);
        viewpager.setOnPageChangeListener(onPageChangeListener);
        oneMvpViewOnePresenter.onViewPrepared();
    }

    @Override
    public void updateData(List<Whether> weather) {
        if (weather != null) {
            mOneAdapter.addItems(weather);
        }
        mRecyclerView.refreshComplete();
        mRecyclerView.setLoadingMoreEnabled(true);
    }

    @Override
    public void refreshData(List<Whether> weather) {
        if (weather != null) {
            mOneAdapter.refreshItems(weather);
        }
        mRecyclerView.refreshComplete();
        mRecyclerView.setLoadingMoreEnabled(true);
    }

    @Override
    public void initPagerData(List<String> urls) {
        this.urls = urls;
        pagerAdapter = new MyPagerAdapter(getActivity(), urls);
        viewpager.setAdapter(pagerAdapter);
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
        initRadioButton(urls.size());

    }

    @Override
    public void onDestroyView() {
        oneMvpViewOnePresenter.onDetachCancleNetWork();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
        super.onDestroyView();
    }

    XRecyclerView.LoadingListener loadingListener = new XRecyclerView.LoadingListener() {
        @Override
        public void onRefresh() {
            times = 0;
            if (scheduledExecutorService != null) {
                index = 0;
                preIndex = 0;
                scheduledExecutorService.shutdown();
                scheduledExecutorService = null;
            }
            oneMvpViewOnePresenter.onViewPrepared();

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
    };

    class ViewPageTask implements Runnable {

        @Override
        public void run() {
            //首先判断是否需要轮播，是的话我们才发消息
            if (isContinue) {
                mHandler.sendEmptyMessage(1);
            }
        }
    }

    /**
     * 根据当前触摸事件判断是否要轮播
     */
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                //手指按下和划动的时候停止图片的轮播
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    isContinue = false;
                    break;
                default:
                    isContinue = true;
            }
            return false;
        }
    };
    /**
     * 根据当前选中的页面设置按钮的选中
     */
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            index = position;//当前位置赋值给索引
            setCurrentDot(index % urls.size());
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    /**
     * 设置对应位置按钮的状态
     *
     * @param i 当前位置
     */
    private void setCurrentDot(int i) {
        if (group.getChildAt(i) != null) {
            group.getChildAt(i).setEnabled(false);//当前按钮选中
        }
        if (group.getChildAt(preIndex) != null) {
            group.getChildAt(preIndex).setEnabled(true);//上一个取消选中
            preIndex = i;//当前位置变为上一个，继续下次轮播
        }
    }

    /**
     * 根据图片个数初始化按钮
     *
     * @param length
     */
    private void initRadioButton(int length) {
        if (length > 0) {
            group.removeAllViews();
        }
        for (int i = 0; i < length; i++) {
            ImageView imageview = new ImageView(getActivity());
            imageview.setImageResource(R.drawable.rg_selector);//设置背景选择器
            imageview.setPadding(20, 0, 0, 0);//设置每个按钮之间的间距
            //将按钮依次添加到RadioGroup中
            group.addView(imageview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //默认选中第一个按钮，因为默认显示第一张图片
            group.getChildAt(0).setEnabled(false);
        }
    }

}
