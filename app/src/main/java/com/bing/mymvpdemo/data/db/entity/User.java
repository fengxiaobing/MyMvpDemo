package com.bing.mymvpdemo.data.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by RF
 * on 2018/1/11.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private long id;
    private String sex;
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }


    @Generated(hash = 252507879)
    public User(long id, String sex, String name) {
        this.id = id;
        this.sex = sex;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
  
}
