package com.utcn.soapApi.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PatientDTO implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private String birthDate;
    private String password;
    private CaregiverDTO caregiver;

    private List<MedicationPlanDTO> medicalRecord;


    public PatientDTO() {
    }

    public PatientDTO(Integer id, String name, String email, String gender, String address, String birthDate, String password, List<MedicationPlanDTO> medicalRecord, CaregiverDTO caregiver) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.password = password;
        this.medicalRecord = medicalRecord;
        this.caregiver = caregiver;
    }

    public PatientDTO(String name, String email, String gender, String address, String birthDate, String password, List<MedicationPlanDTO> medicalRecord, CaregiverDTO caregiver) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.password = password;
        this.medicalRecord = medicalRecord;
        this.caregiver = caregiver;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public List<MedicationPlanDTO> getMedicalRecord() {
        return medicalRecord;
    }

    public String getAddress() {
        return address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMedicalRecord(List<MedicationPlanDTO> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CaregiverDTO getCaregiver() {
        return caregiver;
    }
    public void setCaregiver(CaregiverDTO caregiver) {
        this.caregiver = caregiver;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO patientDTO = (PatientDTO) o;
        return Objects.equals(id, patientDTO.id) &&
                Objects.equals(name, patientDTO.name) &&
                Objects.equals(email, patientDTO.email) &&
                Objects.equals(gender, patientDTO.gender) &&
                Objects.equals(address, patientDTO.address) &&
                Objects.equals (password, patientDTO.password) &&
                Objects.equals (birthDate, patientDTO.birthDate)
                ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, gender, address, password, birthDate);
    }

//    @Override
//    public String toString() {
//        return "PatientDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", gender='" + gender + '\'' +
//                ", address='" + address + '\'' +
//                ", birthDate=" + birthDate +
//                ", password='" + password + '\'' +
//                ", md='" + medicalRecord + '\'' +
//                '}';
//    }
}
