package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.entities.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientViewBuilder {
    public static PatientViewDTO generateDTOFromEntity(Patient patient){
        List<MedicationPlanDTO> medicationPlans =
                (patient.getMedicalRecord () != null)? patient.getMedicalRecord ().stream ()
                .map (MedicationPlanBuilder::generateDTOFromEntity)
                .collect(Collectors.toList()) : null;
        return new PatientViewDTO (
                patient.getName(),
                patient.getEmail(),
                patient.getGender (),
                patient.getAddress (),
                patient.getbirthDate (),
               medicationPlans
        );
    }

    public static Patient generateEntityFromDTO(PatientViewDTO patientViewDTO){
        Patient patient =  new Patient ();
        patient.setName (patientViewDTO.getName ());
        patient.setEmail (patientViewDTO.getEmail ());
        patient.setAddress (patientViewDTO.getAddress ());
        patient.setGender (patientViewDTO.getGender ());
        patient.setBirthDate (patientViewDTO.getBirthDate ());

        return patient;
    }
}
