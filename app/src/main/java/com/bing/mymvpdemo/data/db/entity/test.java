package com.bing.mymvpdemo.data.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/14.
 */
@Entity
public class test {
    @Id
    private Long id;
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1833252049)
    public test(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1102163179)
    public test() {
    }
}
