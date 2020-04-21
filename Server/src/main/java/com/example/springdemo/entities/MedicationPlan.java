package com.example.springdemo.entities;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "medication_plan")
public class MedicationPlan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne()
    @JoinColumn
    private Patient patient;

    @ManyToOne()
    @JoinColumn
    private Doctor doctor;

    @OneToMany(mappedBy = "medicationPlan", fetch = FetchType.EAGER)
    private List<Pill> pills;

    public MedicationPlan(Date startDate, Date endDate, Patient patient, Doctor doctor, List<Pill> pills) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.patient = patient;
        this.doctor = doctor;
        this.pills = pills;
    }
    public MedicationPlan(Integer id, Date startDate, Date endDate, Patient patient, Doctor doctor, List<Pill> pills) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.patient = patient;
        this.doctor = doctor;
        this.pills = pills;
    }

    public MedicationPlan() {
    }

    public Integer getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<Pill> getPills() {
        return pills;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPills(List<Pill> pills) {
        this.pills = pills;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
