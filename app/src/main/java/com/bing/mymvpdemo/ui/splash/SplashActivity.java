

package com.bing.mymvpdemo.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.AppDataManager;
import com.bing.mymvpdemo.data.db.AppDbHelper;
import com.bing.mymvpdemo.data.network.AppApiHelper;
import com.bing.mymvpdemo.data.prefs.AppPreferencesHelper;
import com.bing.mymvpdemo.ui.base.BaseActivity;
import com.bing.mymvpdemo.ui.login.LoginActivity;
import com.bing.mymvpdemo.ui.main.MainActivity;


public class SplashActivity extends BaseActivity implements SplashMvpView {

    private SplashPresenter<SplashMvpView> splashMvpViewSplashPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashMvpViewSplashPresenter = new SplashPresenter<>();
        splashMvpViewSplashPresenter.onAttach(this);
    }

    @Override
    public void openLoginActivity() {


                Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();

    }

    @Override
    public void openMainActivity() {
                Intent intent = MainActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();

    }

    @Override
    public void startSyncService() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashMvpViewSplashPresenter.onDetach();
    }
}
