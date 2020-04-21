package com.example.springdemo.dto;

import com.example.springdemo.services.MedicationDispenserService;

import java.io.Serializable;

public class MonitoredPillDTO implements Serializable {

    private Integer id;

    private String takenDate;

    private String status;


    private PatientDTO patient;


    private MedicationDTO medication;

    public MonitoredPillDTO() {
    }

    public MonitoredPillDTO(Integer id, String takenDate, String status, PatientDTO patient, MedicationDTO medication) {
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

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public MedicationDTO getMedication() {
        return medication;
    }

    public void setMedication(MedicationDTO medication) {
        this.medication = medication;
    }
}
