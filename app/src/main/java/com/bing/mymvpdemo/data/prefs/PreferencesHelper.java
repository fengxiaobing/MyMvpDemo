
package com.bing.mymvpdemo.data.prefs;




public interface PreferencesHelper {

    void setCurrentUserLoggedIn(int mode);

    int getCurrentUserLoggedIn();

    String getAccessToken();

    void setAccessToken(String accessToken);

}
