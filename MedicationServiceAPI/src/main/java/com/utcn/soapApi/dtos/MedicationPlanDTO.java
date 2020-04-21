package com.utcn.soapApi.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MedicationPlanDTO implements Serializable {

    private static final long serialVersionUID = -5577579081118070434L;

    private Integer id;
    private String startDate;
    private String endDate;
    private List<PillDTO> pills;
    private DoctorDTO doctor;
    private PatientDTO patient;

    public MedicationPlanDTO() {}

    public MedicationPlanDTO(Integer id, String startDate, String endDate, List<PillDTO> pills) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pills = pills;
    }

    public MedicationPlanDTO(Integer id, String startDate, String endDate, List<PillDTO> pills, DoctorDTO doctor, PatientDTO patient) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pills = pills;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<PillDTO> getPills() {
        return pills;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPills(List<PillDTO> pills) {
        this.pills = pills;
    }


    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        MedicationPlanDTO that = (MedicationPlanDTO) o;
        return Objects.equals (id, that.id) &&
                Objects.equals (startDate, that.startDate) &&
                Objects.equals (endDate, that.endDate) &&
                Objects.equals (pills, that.pills);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, startDate, endDate, pills);
    }

    @Override
    public String toString() {
        return "MedicationPlanDTO{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pills=" + pills.toString () +
                ", doctor=" + doctor +
                '}';
    }
}
