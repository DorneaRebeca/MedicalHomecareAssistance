package com.utcn.soapApi.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class DoctorDTO implements Serializable {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private List<MedicationPlanDTO> createdPalns = null;

    public DoctorDTO(){}

    public DoctorDTO(Integer id, String name, String email, String password, List<MedicationPlanDTO> createdPalns) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdPalns = createdPalns;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<MedicationPlanDTO> getCreatedPalns() {
        return createdPalns;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setCreatedPalns(List<MedicationPlanDTO> createdPalns) {
        this.createdPalns = createdPalns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        DoctorDTO doctorDTO = (DoctorDTO) o;
        return Objects.equals (id, doctorDTO.id) &&
                Objects.equals (name, doctorDTO.name) &&
                Objects.equals (email, doctorDTO.email) &&
                Objects.equals (password, doctorDTO.password) &&
                Objects.equals (createdPalns, doctorDTO.createdPalns);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, name, email, password, createdPalns);
    }
}
