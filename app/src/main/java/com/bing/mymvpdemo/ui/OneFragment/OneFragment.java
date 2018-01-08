package com.bing.mymvpdemo.ui.OneFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by RF
 * on 2018/1/8.
 */

public class OneFragment extends BaseFragment implements OneMvpView {
    @BindView(R.id.textView)
    TextView textView;
    private OnePresenter<OneMvpView> oneMvpViewOnePresenter;

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

    }

    @Override
    public void onDestroyView() {
        oneMvpViewOnePresenter.onDetach();
        super.onDestroyView();
    }

    @OnClick(R.id.textView)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "哈哈", Toast.LENGTH_SHORT).show();
    }
}
