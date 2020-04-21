package com.utcn.monitoringSys.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonitoredData implements Serializable {

    private String activity;
    private String start;
    private String end;
    private Integer patient_id;

    public MonitoredData(String activity, String start, String end, Integer patient_id) {
        this.activity = activity;
        this.start = start;
        this.end = end;
        this.patient_id = patient_id;
    }

    public MonitoredData() {}


    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    @Override
    public String toString() {
        return "Data [activity="
                + activity
                + ", start="
                + start
                + ", end="
                + end
                + "patient_id=" + patient_id + "]";

    }

}
