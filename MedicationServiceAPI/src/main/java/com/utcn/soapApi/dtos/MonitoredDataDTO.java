package com.utcn.soapApi.dtos;

import java.io.Serializable;

public class MonitoredDataDTO implements Serializable {

    private Integer id;

    private String activity;

    private String start;

    private Boolean anomaly;

    private String end;

    private PatientDTO patient;

    public MonitoredDataDTO() {}

    public MonitoredDataDTO(String activity, String start, String end, PatientDTO patient, Boolean anomaly) {
        this.activity = activity;
        this.start = start;
        this.end = end;
        this.patient = patient;
        this.anomaly = anomaly;
    }

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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(Boolean anomaly) {
        this.anomaly = anomaly;
    }

    @Override
    public String toString() {
        return "Data [activity="
                + activity
                + ", start="
                + start
                + ", end="
                + end
                + "patient_id=" + patient.getId()+ "]";

    }



}
