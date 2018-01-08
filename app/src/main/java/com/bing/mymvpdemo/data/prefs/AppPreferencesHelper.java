/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bing.mymvpdemo.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.bing.mymvpdemo.App;
import com.bing.mymvpdemo.utils.SharedPreferencesHelper;


public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    @Override
    public void setCurrentUserLoggedIn(int mode) {
        SharedPreferencesHelper.putInt(App.getContext(),PREF_KEY_CURRENT_USER_ID,mode);
    }

    @Override
    public int getCurrentUserLoggedIn() {
        return  SharedPreferencesHelper.getInt(App.getContext(),PREF_KEY_CURRENT_USER_ID,0);
    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
