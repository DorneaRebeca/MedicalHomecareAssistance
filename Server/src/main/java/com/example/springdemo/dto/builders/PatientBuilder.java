package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Patient;

import javax.print.Doc;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientBuilder {

    public PatientBuilder() {
    }

    public static PatientDTO generateDTOFromEntity(Patient patient){
        List<MedicationPlanDTO> medicationPlans = new LinkedList<> ();
        if(patient != null && patient.getMedicalRecord () != null) {
            for (MedicationPlan mp : patient.getMedicalRecord ()
            ) {
                medicationPlans.add (setMedPlanDTO (mp));
            }
        }
        CaregiverDTO caregiver =
                (patient.getCaregiver () != null) ?
                setCaregiverDTO (patient.getCaregiver ()) : null;

        return new PatientDTO (
                patient.getId (),
                patient.getName (),
                patient.getEmail (),
                patient.getGender (),
                patient.getAddress (),
                patient.getbirthDate ().toString(),
                patient.getPassword (),
                medicationPlans,
                caregiver
        );
    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO){
        List<MedicationPlan> medicationPlans =
                (patientDTO.getMedicalRecord () != null)?  patientDTO.getMedicalRecord ().stream ()
                .map (PatientBuilder::setMedPlanEntity)
                .collect(Collectors.toList()) : null;

        Caregiver caregiver = setCaregiverEntity (patientDTO.getCaregiver ());
        return new Patient (
                patientDTO.getId (),
                patientDTO.getName (),
                patientDTO.getEmail (),
                Date.valueOf(patientDTO.getBirthDate ()),
                patientDTO.getAddress (),
                patientDTO.getGender (),
                patientDTO.getPassword (),
                medicationPlans,
                caregiver
                );
    }

    private static CaregiverDTO setCaregiverDTO(Caregiver caregiver) {
        CaregiverDTO caregiverDTO = new CaregiverDTO ();
        caregiverDTO.setId (caregiver.getId ());
        caregiverDTO.setBirthDate (caregiver.getBirth_date ().toString());
        caregiverDTO.setEmail (caregiver.getEmail ());
        caregiverDTO.setGender (caregiver.getGender ());
        caregiverDTO.setPassword (caregiver.getPassword ());
        caregiverDTO.setAddress (caregiver.getAddress ());
        caregiverDTO.setName (caregiver.getName ());
        caregiverDTO.setPatients (null);
        return caregiverDTO;
    }
    private static Caregiver setCaregiverEntity(CaregiverDTO caregiver) {
        Caregiver c = new Caregiver();
        c.setId (caregiver.getId ());
        c.setBirth_date (Date.valueOf(caregiver.getBirthDate ()));
        c.setEmail (caregiver.getEmail ());
        c.setGender (caregiver.getGender ());
        c.setPassword (caregiver.getPassword ());
        c.setAddress (caregiver.getAddress ());
        c.setName (caregiver.getName ());
        c.setPatients (null);
        return c;
    }

    private static MedicationPlanDTO setMedPlanDTO(MedicationPlan medicationPlan) {
        MedicationPlanDTO medicationPlanDTO = new MedicationPlanDTO ();
        DoctorDTO doctor = new DoctorDTO ();
        doctor.setId (medicationPlan.getDoctor ().getId ());
        doctor.setName (medicationPlan.getDoctor ().getName ());
        doctor.setEmail (medicationPlan.getDoctor ().getEmail ());
        medicationPlanDTO.setDoctor (doctor);
        medicationPlanDTO.setPatient (null);
        medicationPlanDTO.setEndDate (
                medicationPlan.getEndDate ().toString()
        );
        medicationPlanDTO.setStartDate (
                medicationPlan.getStartDate ().toString()
        );
        medicationPlanDTO.setId (
                medicationPlan.getId ()
        );
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
        medicationPlanDTO.setPatient (null);
        medicationPlanDTO.setEndDate (
                Date.valueOf(medicationPlan.getEndDate ())
        );
        medicationPlanDTO.setStartDate (
                Date.valueOf(medicationPlan.getStartDate ())
        );
        medicationPlanDTO.setId (
                medicationPlan.getId ()
        );
        medicationPlanDTO.setPills (
                medicationPlan.getPills ().stream ()
                        .map (PillBuilder::generateEntityFromDTO)
                        .collect(Collectors.toList())
        );
        return medicationPlanDTO;
    }

}
