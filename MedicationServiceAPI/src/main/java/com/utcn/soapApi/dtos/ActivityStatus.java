package com.utcn.soapApi.dtos;

import java.io.Serializable;

public class ActivityStatus implements Serializable {

    private String activity;
    private Long time;
    public ActivityStatus(){}

    public ActivityStatus(String activity, Long time) {
        this.activity = activity;
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
