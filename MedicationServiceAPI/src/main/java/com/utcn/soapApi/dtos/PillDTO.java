package com.utcn.soapApi.dtos;

import java.io.Serializable;
import java.util.Objects;

public class PillDTO implements Serializable {

    private Integer id;
    private MedicationDTO medication = null;
    private String intakeInterval;
    private MedicationPlanDTO medicationPlanDTO;

    public PillDTO(){}

    public PillDTO(Integer id, MedicationDTO medication, String intakeInterval, MedicationPlanDTO medicationPlanDTO) {
        this.id = id;
        this.medication = medication;
        this.intakeInterval = intakeInterval;
        this.medicationPlanDTO = medicationPlanDTO;
    }

    public Integer getId() {
        return id;
    }

    public MedicationDTO getMedication() {
        return medication;
    }

    public String getIntakeInterval() {
        return intakeInterval;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMedication(MedicationDTO medication) {
        this.medication = medication;
    }

    public void setIntakeInterval(String intakeInterval) {
        this.intakeInterval = intakeInterval;
    }

    public MedicationPlanDTO getMedicationPlanDTO() {
        return medicationPlanDTO;
    }

    public void setMedicationPlanDTO(MedicationPlanDTO medicationPlanDTO) {
        this.medicationPlanDTO = medicationPlanDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        PillDTO pillDTO = (PillDTO) o;
        return intakeInterval == pillDTO.intakeInterval &&
                Objects.equals (id, pillDTO.id) &&
                Objects.equals (medication, pillDTO.medication);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, medication, intakeInterval);
    }

    @Override
    public String toString() {
        return "PillDTO{" +
                "id=" + id +
                ", medication=" + medication.getId () +
                ", intakeInterval=" + intakeInterval +
                '}';
    }
}
