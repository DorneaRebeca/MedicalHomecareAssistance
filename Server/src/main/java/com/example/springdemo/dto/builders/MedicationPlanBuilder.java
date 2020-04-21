package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.entities.Doctor;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.Pill;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MedicationPlanBuilder {

    public static MedicationPlanDTO generateDTOFromEntity(MedicationPlan medicationPlan){
        List<PillDTO> pillDTOS =
                (medicationPlan.getPills () != null)? medicationPlan.getPills ().stream ()
                .map (PillBuilder::generateDTOFromEntity)
                .collect(Collectors.toList()) : null;
        DoctorDTO doc =
                (medicationPlan.getDoctor () != null)? setDoctorDTO (medicationPlan.getDoctor ())
                        : null;
//        PatientDTO patient =
//                (medicationPlan.getPatient () != null)?  PatientBuilder.generateDTOFromEntity (medicationPlan.getPatient ())
//                        : null;
           PatientDTO p = new PatientDTO ();
        if(medicationPlan.getPatient () != null) {
            p.setId (medicationPlan.getPatient ().getId ());
            p.setEmail (medicationPlan.getPatient ().getEmail ());
        }
        return new MedicationPlanDTO (
                medicationPlan.getId (),
                medicationPlan.getStartDate ().toString(),
                medicationPlan.getEndDate ().toString(),
                pillDTOS,
                doc,
                p
        );
    }

    public static MedicationPlan generateEntityFromDTO(MedicationPlanDTO medicationPlanDTO){
        List<Pill> pills =
                (medicationPlanDTO.getPills () != null)? medicationPlanDTO.getPills ().stream ()
                .map (PillBuilder::generateEntityFromDTO)
                .collect(Collectors.toList()) : null;
        Doctor doc =
                (medicationPlanDTO.getDoctor () != null)? setDoctorEntity (medicationPlanDTO.getDoctor ())
                        : null;
        Patient patient =
                (medicationPlanDTO.getPatient () != null)?  PatientBuilder.generateEntityFromDTO (medicationPlanDTO.getPatient ())
                        : null;
        return new MedicationPlan (
                medicationPlanDTO.getId (),
                Date.valueOf(medicationPlanDTO.getStartDate ()),
                Date.valueOf(medicationPlanDTO.getEndDate ()),
                patient,
                doc,
                pills
        );
    }

    private static DoctorDTO setDoctorDTO(Doctor doctor)
    {
        DoctorDTO doctorDTO = new DoctorDTO ();
        doctorDTO.setCreatedPalns (null);
        doctorDTO.setEmail (doctor.getEmail ());
        doctorDTO.setId (doctor.getId ());
        doctorDTO.setName (doctor.getName ());
        doctorDTO.setPassword (doctor.getPassword ());
        return doctorDTO;
    }

    private static Doctor setDoctorEntity(DoctorDTO doctor)
    {
        Doctor doctorDTO = new Doctor ();
        doctorDTO.setCreatedPalns (null);
        doctorDTO.setEmail (doctor.getEmail ());
        doctorDTO.setId (doctor.getId ());
        doctorDTO.setName (doctor.getName ());
        doctorDTO.setPassword (doctor.getPassword ());
        return doctorDTO;
    }
}
