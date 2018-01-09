package com.bing.mymvpdemo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BaseActivity;
import com.bing.mymvpdemo.ui.login.LoginActivity;
import com.bing.mymvpdemo.ui.widget.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainMvpView {

    MainPresenter<MainMvpView> mainMvpViewMainPresenter;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    @BindView(R.id.btn_notice)
    RadioButton btnNotice;
    @BindView(R.id.btn_work)
    RadioButton btnWork;
    @BindView(R.id.btn_contacts)
    RadioButton btnContacts;
    @BindView(R.id.btn_own)
    RadioButton btnOwn;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.title)
    TextView title;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainMvpViewMainPresenter = new MainPresenter<>();
        mainMvpViewMainPresenter.onAttach(this);

        init();
    }

    private void init() {
        FragmentManager fm = getSupportFragmentManager();
        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(fm);
        mPagerAdapter.setCount(4);
        viewpager.setAdapter(mPagerAdapter);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setRadioBtnChecked(checkedId);
                switch (checkedId) {
                    case R.id.btn_notice:
                        viewpager.setCurrentItem(0);
                        title.setText("任务");
                        break;
                    case R.id.btn_work:
                        viewpager.setCurrentItem(1);
                        title.setText("工作");
                        break;
                    case R.id.btn_contacts:
                        viewpager.setCurrentItem(2);
                        title.setText("通讯录");
                        break;
                    case R.id.btn_own:
                        viewpager.setCurrentItem(3);
                        title.setText("个人中心");
                        break;

                }
            }
        });
        viewpager.setCurrentItem(0); //设置当前页是第一页
        //默认选中首页
        radiogroup.check(R.id.btn_notice);
    }

    private void setRadioBtnChecked(int id) {
        RadioButton btn1 = findViewById(R.id.btn_notice);
        btn1.setTextColor(Color.parseColor("#92a1b0"));
        btn1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.notice), null, null);

        RadioButton btn2 = findViewById(R.id.btn_work);
        btn2.setTextColor(Color.parseColor("#92a1b0"));
        btn2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.work), null, null);

        RadioButton btn3 = findViewById(R.id.btn_own);
        btn3.setTextColor(Color.parseColor("#92a1b0"));
        btn3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.own), null, null);

        RadioButton btn4 = findViewById(R.id.btn_contacts);
        btn4.setTextColor(Color.parseColor("#92a1b0"));
        btn4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contacts), null, null);

        RadioButton btn = findViewById(id);
        switch (id) {
            case R.id.btn_notice:
                btn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.notice_press), null, null);
                break;
            case R.id.btn_work:
                btn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.work_press), null, null);
                break;
            case R.id.btn_own:
                btn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.own_press), null, null);
                break;
            case R.id.btn_contacts:
                btn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contacts_press), null, null);
                break;

        }
        btn.setTextColor(Color.parseColor("#6b8ccc"));
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainMvpViewMainPresenter.onDetach();
    }

    @OnClick({R.id.btn_notice, R.id.btn_work, R.id.btn_contacts, R.id.btn_own})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_notice:
                break;
            case R.id.btn_work:
                break;
            case R.id.btn_contacts:
                break;
            case R.id.btn_own:
                break;
        }
    }
}
