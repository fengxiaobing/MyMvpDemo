
package com.bing.mymvpdemo.data;
import com.bing.mymvpdemo.data.db.DbHelper;
import com.bing.mymvpdemo.data.network.ApiHelper;
import com.bing.mymvpdemo.data.prefs.PreferencesHelper;


public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {


}
