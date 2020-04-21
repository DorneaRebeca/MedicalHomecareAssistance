package com.example.springdemo.dto;

import java.io.Serializable;

public class MedicationDTO implements Serializable {

    private Integer id;
    private String name;
    private String sideEffects;
    private int dosage;

    public MedicationDTO() {}

    public MedicationDTO(Integer id, String name, String sideEffects, int dosage) {
        this.id = id;
        this.name = name;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
