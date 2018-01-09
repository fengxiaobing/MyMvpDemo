package com.bing.mymvpdemo.data.network.model;

/**
 * Created by RF
 * on 2018/1/9.
 */

    public  class Whether {

    /**
     * code : 1
     * temperature : 3
     * text : 晴
     * time : 2018-01-09T18:00:00+08:00
     */

    private String code;
    private String temperature;
    private String text;
    private String time;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

