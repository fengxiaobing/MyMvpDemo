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
    private Long id;
    private String sex;
    private String name;
    private String hobby;
    private String age;
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getHobby() {
        return this.hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Generated(hash = 1541234349)
    public User(Long id, String sex, String name, String hobby, String age) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.hobby = hobby;
        this.age = age;
    }
    public User() {
        this.id = null;
    }
    public User(Builder builder) {
        this.id = null;
        this.sex = builder.sex;
        this.name = builder.name;
        this.hobby = builder.hobby;
        this.age = builder.age;
    }

    public static class Builder{
        private Long id;
        private String sex;
        private String name;
        private String hobby;
        private String age;
        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }
        public Builder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }
        public Builder setAge(String age) {
            this.age = age;
            return this;
        }
        public User builder(){
            return new User(this);
        }
    }


}
