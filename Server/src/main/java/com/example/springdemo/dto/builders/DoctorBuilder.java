package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.entities.Doctor;
import com.example.springdemo.entities.MedicationPlan;


import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorBuilder {


    public static DoctorDTO generateDTOFromEntity(Doctor doctor){
        List<MedicationPlanDTO> medicationPlans = new LinkedList<> ();
        if(doctor.getCreatedPalns () != null) {
            for (MedicationPlan mp : doctor.getCreatedPalns ()
            ) {
                medicationPlans.add (setMedPlanDTO (mp));
            }
        }
        return new DoctorDTO (
                doctor.getId (),
                doctor.getName (),
                doctor.getEmail (),
                doctor.getPassword (),
                medicationPlans
        );
    }

    public static Doctor generateEntityFromDTO(DoctorDTO doctorDTO){
        List<MedicationPlan> medicationPlans =
                (doctorDTO.getCreatedPalns () != null)? doctorDTO.getCreatedPalns ().stream ()
                .map (MedicationPlanBuilder::generateEntityFromDTO)
                .collect(Collectors.toList()) : null;
        return new Doctor (
                doctorDTO.getId (),
                doctorDTO.getName (),
                doctorDTO.getEmail (),
                doctorDTO.getPassword (),
                medicationPlans
        );
    }


    private static MedicationPlanDTO setMedPlanDTO(MedicationPlan medicationPlan) {
        MedicationPlanDTO medicationPlanDTO = new MedicationPlanDTO ();
        medicationPlanDTO.setDoctor (null);
        if(medicationPlan.getPatient () != null )
            medicationPlanDTO.setPatient (PatientBuilder.generateDTOFromEntity (medicationPlan.getPatient ()));
        else  medicationPlanDTO.setPatient (null);
        medicationPlanDTO.setEndDate (medicationPlan.getEndDate ().toString());
        medicationPlanDTO.setStartDate (medicationPlan.getStartDate ().toString());
        medicationPlanDTO.setId (medicationPlan.getId ());
        medicationPlanDTO.setPills (
                medicationPlan.getPills ().stream ()
                        .map (PillBuilder::generateDTOFromEntity)
                        .collect(Collectors.toList())
        );
        return medicationPlanDTO;
    }

    private static MedicationPlan setMedPlanEntity(MedicationPlanDTO medicationPlan) {
        MedicationPlan medicationPlanDTO = new MedicationPlan ();
        medicationPlanDTO.setDoctor (null);
        if(medicationPlan.getPatient () != null )
            medicationPlanDTO.setPatient (PatientBuilder.generateEntityFromDTO (medicationPlan.getPatient ()));
        else  medicationPlanDTO.setPatient (null);
        medicationPlanDTO.setEndDate (Date.valueOf(medicationPlan.getEndDate ()));
        medicationPlanDTO.setStartDate (Date.valueOf(medicationPlan.getStartDate ()));
        medicationPlanDTO.setId (medicationPlan.getId ());
        medicationPlanDTO.setPills (
                medicationPlan.getPills ().stream ()
                        .map (PillBuilder::generateEntityFromDTO)
                        .collect(Collectors.toList())
        );
        return medicationPlanDTO;
    }
}
