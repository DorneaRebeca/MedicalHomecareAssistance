package com.example.springdemo.entities;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "monitored_pills")
public class MonitoredPill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "taken_date")
    private Date takenDate;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="medication")
    private Medication medication;

    public MonitoredPill() {
    }

    public MonitoredPill(Date takenDate, String status, Patient patient, Medication medication) {
        this.takenDate = takenDate;
        this.status = status;
        this.patient = patient;
        this.medication = medication;
    }

    public MonitoredPill(Integer id, Date takenDate, String status, Patient patient, Medication medication) {
        this.id = id;
        this.takenDate = takenDate;
        this.status = status;
        this.patient = patient;
        this.medication = medication;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
