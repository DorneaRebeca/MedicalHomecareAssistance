package com.example.springdemo.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pill")
public class Pill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Medication medication;

    @Column(name = "intake_interval")
    private String intakeInterval;

    @ManyToOne
    @JoinColumn
    private MedicationPlan medicationPlan;

    public Pill(Medication medication, String intakeInterval, MedicationPlan medicationPlan) {
        this.medication = medication;
        this.intakeInterval = intakeInterval;
        this.medicationPlan = medicationPlan;
    }
    public Pill(Integer id, Medication medication, String intakeInterval, MedicationPlan medicationPlan) {
        this.id = id;
        this.medication = medication;
        this.intakeInterval = intakeInterval;
        this.medicationPlan = medicationPlan;
    }

    public Pill() {
    }

    public Integer getId() {
        return id;
    }

    public Medication getMedication() {
        return medication;
    }

    public String getIntakeInterval() {
        return intakeInterval;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void setIntakeInterval(String intakeInterval) {
        this.intakeInterval = intakeInterval;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    @Override
    public String toString() {
        return "Pill{" +
                "id=" + id +
                ", medication=" + medication.getId () +
                ", intakeInterval=" + intakeInterval +
                ", medicationPlan=" + medicationPlan +
                ", medicationPlan=" + medicationPlan +
                '}';
    }
}
