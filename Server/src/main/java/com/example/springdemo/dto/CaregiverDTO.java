package com.example.springdemo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CaregiverDTO implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private String birthDate;
    private String password;
    private List<PatientDTO> patients;


    public CaregiverDTO() {
    }

    public CaregiverDTO(Integer id, String name, String email, String gender, String address, String birthDate, String password, List<PatientDTO> patients) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.password = password;
        this.patients = patients = patients;
    }

    public CaregiverDTO( String name, String email, String gender, String address, String birthDate, String password, List<PatientDTO> patients) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.password = password;
        this.patients = patients;
    }

    public CaregiverDTO( String name, String email, String gender, String address, String birthDate, String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.password = password;
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

    public List<PatientDTO> getPatients() {
        return patients;
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

    public void setPatients (List<PatientDTO> patients) {
        this.patients = patients;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaregiverDTO caregiverDTO = (CaregiverDTO) o;
        return Objects.equals(id, caregiverDTO.id) &&
                Objects.equals(name, caregiverDTO.name) &&
                Objects.equals(email, caregiverDTO.email) &&
                Objects.equals(gender, caregiverDTO.gender) &&
                Objects.equals(address, caregiverDTO.address) &&
                Objects.equals (password, caregiverDTO.password) &&
                Objects.equals (birthDate, caregiverDTO.birthDate)
                ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, gender, address, password, birthDate);
    }

    @Override
    public String toString() {
        return "CaregiverDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", pat='" + patients + '\'' +
                '}';
    }
}
