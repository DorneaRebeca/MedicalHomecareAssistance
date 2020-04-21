package com.example.springdemo.entities;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<MedicationPlan> createdPlans;


    public Doctor(String name, String email, String password, List<MedicationPlan> createdPlans) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdPlans = createdPlans;
    }
    public Doctor(Integer id, String name, String email, String password, List<MedicationPlan> createdPlans) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdPlans = createdPlans;
    }

    public Doctor() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public List<MedicationPlan> getCreatedPalns() {
        return createdPlans;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreatedPalns(List<MedicationPlan> createdPlans) {
        this.createdPlans = createdPlans;
    }
}
