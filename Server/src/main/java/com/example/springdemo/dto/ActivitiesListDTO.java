package com.example.springdemo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesListDTO implements Serializable {

    private List<MonitoredDataDTO> activities;

    public ActivitiesListDTO() {
    }

    public ActivitiesListDTO(List<MonitoredDataDTO> activities) {
        this.activities = activities;
    }

    public List<MonitoredDataDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<MonitoredDataDTO> activities) {
        this.activities = activities;
    }
}
