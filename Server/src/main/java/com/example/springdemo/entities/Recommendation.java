package com.example.springdemo.entities;

import javax.persistence.*;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "recommendation")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idrecommandations", unique = true, nullable = false)
    private Integer id;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="caregiver_id")
    private Caregiver caregiver;


    public Recommendation() {
    }

    public Recommendation(String message, Patient patient, Caregiver caregiver) {
        this.message = message;
        this.patient = patient;
        this.caregiver = caregiver;
    }

    public Recommendation(Integer id, String message, Patient patient, Caregiver caregiver) {
        this.message = message;
        this.patient = patient;
        this.caregiver = caregiver;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
