package com.example.springdemo.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<MedicationPlan> medicalRecord;

    @ManyToOne
    @JoinColumn
    private Caregiver caregiver;

    public Patient() {
        super();
    }

    public Patient(String name, String email, Date birthDate, String address, String gender, String password, List<MedicationPlan> medicalRecord, Caregiver caregiver) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.password = password;
        this.medicalRecord = medicalRecord;
        this.caregiver = caregiver;
    }

    public Patient(Integer id, String name, String email, Date birthDate, String address, String gender, String password,List<MedicationPlan> medicalRecord, Caregiver caregiver) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
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

    public void setbirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMedicalRecord(List<MedicationPlan> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Date getbirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public List<MedicationPlan> getMedicalRecord() {
        return medicalRecord;
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

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
               // ", medicalRecord=" + medicalRecord +
                ", caregiver=" + caregiver.getName () +
                '}';
    }
}
