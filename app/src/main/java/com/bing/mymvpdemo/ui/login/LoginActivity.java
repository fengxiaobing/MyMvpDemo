package com.bing.mymvpdemo.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.AppDataManager;
import com.bing.mymvpdemo.data.db.AppDbHelper;
import com.bing.mymvpdemo.data.network.AppApiHelper;
import com.bing.mymvpdemo.data.prefs.AppPreferencesHelper;
import com.bing.mymvpdemo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginMvpView {

    LoginPresenter<LoginMvpView> loginMvpViewLoginPresenter;
    @BindView(R.id.btn_login)
    Button btnLogin;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginMvpViewLoginPresenter = new LoginPresenter<>();
        loginMvpViewLoginPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginMvpViewLoginPresenter.onDetach();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginMvpViewLoginPresenter.submit();
    }
}
