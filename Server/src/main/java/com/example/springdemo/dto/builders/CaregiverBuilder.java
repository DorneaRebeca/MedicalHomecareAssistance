package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CaregiverBuilder {

    public static CaregiverDTO generateDTOFromEntity(Caregiver caregiver){
        List<PatientDTO> patientDTOS =
                (caregiver.getPatients () != null)? caregiver.getPatients ().stream ()
                .map (PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList()) : null;
        return new CaregiverDTO (
                caregiver.getId (),
                caregiver.getName (),
                caregiver.getEmail (),
                caregiver.getGender (),
                caregiver.getAddress (),
                caregiver.getBirth_date ().toString(),
                caregiver.getPassword (),
                patientDTOS
        );
    }

    public static Caregiver generateEntityFromDTO(CaregiverDTO caregiverDTO){

        List<Patient> patients =
                (caregiverDTO.getPatients () != null)? caregiverDTO.getPatients ().stream ()
                .map (PatientBuilder::generateEntityFromDTO)
                .collect(Collectors.toList()) : null;
        return new Caregiver (
                caregiverDTO.getId (),
                caregiverDTO.getName (),
                caregiverDTO.getEmail (),
                (caregiverDTO.getBirthDate() != null) ? Date.valueOf(caregiverDTO.getBirthDate ()) : null,
                caregiverDTO.getAddress (),
                caregiverDTO.getGender (),
                caregiverDTO.getPassword (),
                patients
        );
    }
}
