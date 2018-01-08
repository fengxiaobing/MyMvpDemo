
package com.bing.mymvpdemo.data;

import com.bing.mymvpdemo.data.db.DbHelper;
import com.bing.mymvpdemo.data.network.ApiHelper;
import com.bing.mymvpdemo.data.prefs.PreferencesHelper;

public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private static AppDataManager appDataManager = null;


    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private AppDataManager(DbHelper mDbHelper, PreferencesHelper mPreferencesHelper, ApiHelper mApiHelper) {
        this.mDbHelper = mDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
        this.mApiHelper = mApiHelper;
    }

    public synchronized static  AppDataManager getInstance(DbHelper mDbHelper, PreferencesHelper mPreferencesHelper, ApiHelper mApiHelper){
                if(appDataManager == null) {
                    appDataManager = new AppDataManager(mDbHelper, mPreferencesHelper, mApiHelper);
                }
        return appDataManager;
    }

    @Override
    public void setCurrentUserLoggedIn(int mode) {
        mPreferencesHelper.setCurrentUserLoggedIn(mode);
    }

    @Override
    public int getCurrentUserLoggedIn() {
        return mPreferencesHelper.getCurrentUserLoggedIn();
    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
