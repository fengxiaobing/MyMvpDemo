package com.bing.mymvpdemo.ui.main.ThreeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.db.entity.User;
import com.bing.mymvpdemo.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class ThreeFragment extends BaseFragment implements ThreeMvpView {
    @BindView(R.id.textView)
    TextView textView;

    private ThreeMvpPresenter<ThreeMvpView> threeMvpViewThreePresenter;

    public static ThreeFragment newInstance() {
        Bundle args = new Bundle();
        ThreeFragment fragment = new ThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        threeMvpViewThreePresenter = new ThreePresenter<>();
        threeMvpViewThreePresenter.onAttach(this);
         ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {
        threeMvpViewThreePresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        threeMvpViewThreePresenter.onDetach();
    }

    @OnClick(R.id.textView)
    public void onViewClicked() {
        threeMvpViewThreePresenter.QueryData();
    }


    @Override
    public void showDbData(List<User> userList) {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < userList.size(); i++) {
            names.append(userList.get(i).getName()).append("\n");
        }
        textView.setText(names.toString());
    }
}
