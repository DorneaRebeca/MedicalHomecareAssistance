package com.example.springdemo.dto;

import java.sql.Date;
import java.util.List;

public class PatientViewDTO {

    private String name;
    private String email;
    private String gender;
    private String address;
    private Date birthDate;
    private List<MedicationPlanDTO> medicationPlans = null;

    public PatientViewDTO(String name, String email, String gender, String address, Date birthDate, List<MedicationPlanDTO> medicationPlans) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.medicationPlans = medicationPlans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<MedicationPlanDTO> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlanDTO> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }

    @Override
    public String toString() {
        return "PatientViewDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", medicationPlans=" + medicationPlans +
                '}';
    }
}
