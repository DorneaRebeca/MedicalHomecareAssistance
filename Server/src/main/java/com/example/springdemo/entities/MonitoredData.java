package com.example.springdemo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "activity")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonitoredData {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idactivity", unique = true, nullable = false)
    private Integer id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "start")
    private String start;

    @Column(name = "anomaly", columnDefinition = "TINYINT()")
    private boolean anomaly;

    @Column(name = "end")
    private String end;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="patient_id")
    private Patient patient;

    public MonitoredData(String activity, String start, String end, Patient patient, Boolean anomaly) {
        this.activity = activity;
        this.start = start;
        this.end = end;
        this.patient = patient;
        this.anomaly = anomaly;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
                + "patient_id=" + patient+ "]";

    }

}
