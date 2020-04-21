package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.entities.Medication;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Pill;

import java.sql.Date;
import java.util.stream.Collectors;

public class PillBuilder {
    public static PillDTO generateDTOFromEntity(Pill pill){
        MedicationDTO med =
                (pill.getMedication () != null )? MedicationBuilder.generateDTOFromEntity (pill.getMedication ()) : null;

        return new PillDTO (
                pill.getId (),
                med,
                pill.getIntakeInterval (),
                null
        );
    }

    public static Pill generateEntityFromDTO(PillDTO pillDTO) {
        Medication med =
                (pillDTO.getMedication () != null) ? MedicationBuilder.generateEntityFromDTO (pillDTO.getMedication ())
                        : null;
        MedicationPlan medicationPlan = (pillDTO.getMedicationPlanDTO () != null) ? setMedPlanEntity (pillDTO.getMedicationPlanDTO ())
                : null;
        return new Pill (
                pillDTO.getId (),
                med,
                pillDTO.getIntakeInterval (),
                medicationPlan
        );
    }

        private static MedicationPlanDTO setMedPlanDTO(MedicationPlan medicationPlan) {
            MedicationPlanDTO medicationPlanDTO = new MedicationPlanDTO ();
            if(medicationPlan.getDoctor () != null)
                medicationPlanDTO.setDoctor (DoctorBuilder.generateDTOFromEntity (medicationPlan.getDoctor ()));
            else medicationPlanDTO.setDoctor (null);
            if(medicationPlan.getPatient () != null )
                medicationPlanDTO.setPatient (PatientBuilder.generateDTOFromEntity (medicationPlan.getPatient ()));
            else  medicationPlanDTO.setPatient (null);
            medicationPlanDTO.setEndDate (
                    medicationPlan.getEndDate ().toString()
            );
            medicationPlanDTO.setStartDate (
                    medicationPlan.getStartDate ().toString()
            );
            medicationPlanDTO.setId (
                    medicationPlan.getId ()
            );
            medicationPlanDTO.setPills (null);
            return medicationPlanDTO;
    }

    private static MedicationPlan setMedPlanEntity(MedicationPlanDTO medicationPlan) {
        MedicationPlan medicationPlanDTO = new MedicationPlan ();
        if(medicationPlan.getDoctor () != null)
            medicationPlanDTO.setDoctor (DoctorBuilder.generateEntityFromDTO (medicationPlan.getDoctor ()));
        else medicationPlanDTO.setDoctor (null);
        if(medicationPlan.getPatient () != null )
            medicationPlanDTO.setPatient (PatientBuilder.generateEntityFromDTO (medicationPlan.getPatient ()));
        else  medicationPlanDTO.setPatient (null);
        medicationPlanDTO.setEndDate (
                Date.valueOf(medicationPlan.getEndDate ())
        );
        medicationPlanDTO.setStartDate (
                Date.valueOf(medicationPlan.getStartDate ())
        );
        medicationPlanDTO.setId (medicationPlan.getId ());
        medicationPlanDTO.setPills (null);
        return medicationPlanDTO;
    }
}
