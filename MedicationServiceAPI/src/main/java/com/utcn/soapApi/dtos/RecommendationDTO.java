package com.utcn.soapApi.dtos;

import java.io.Serializable;

public class RecommendationDTO implements Serializable {

    private Integer id;

    private String message;

    private PatientDTO patient;

    private CaregiverDTO caregiver;

    public RecommendationDTO() {
    }

    public RecommendationDTO(Integer id, String message, PatientDTO patient, CaregiverDTO caregiver) {
        this.id = id;
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public CaregiverDTO getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(CaregiverDTO caregiver) {
        this.caregiver = caregiver;
    }
}
