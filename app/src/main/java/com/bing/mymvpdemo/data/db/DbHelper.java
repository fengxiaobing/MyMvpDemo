

package com.bing.mymvpdemo.data.db;


import com.bing.mymvpdemo.data.db.entity.User;

import java.util.List;

public interface DbHelper {

    List<User> getAllUsers();
   void insertUsers(User user);
}
