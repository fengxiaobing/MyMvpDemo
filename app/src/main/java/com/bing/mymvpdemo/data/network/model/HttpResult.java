package com.bing.mymvpdemo.data.network.model;


import java.io.Serializable;

/**

/**
 * Created by RF 
 * on 2016/12/23.
 * 实体的基类
 */
public class HttpResult<T> implements Serializable {
    public String status;
    public  T hourly;
    public String message;
    public String version;
}
