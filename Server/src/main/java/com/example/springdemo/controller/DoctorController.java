package com.example.springdemo.controller;

import com.example.springdemo.dto.*;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/patient/{idPatient}")
    public PatientDTO findPatientById(@PathVariable("idPatient") Integer id){
        PatientDTO p =  doctorService.findPatientById(id);
        return p;
    }

    @GetMapping("/allPatients")
    public List<PatientDTO> findAllPatients(){
        List<PatientDTO> p =  doctorService.findAllPatients ();
        return p;

    }

    @PostMapping("/newPatient")
    public void insertPatient(@RequestBody PatientDTO patientDTO){
        doctorService.insertPatient (patientDTO);
    }

    @PutMapping("/updatePatient")
    public void updatePatient(@RequestBody PatientDTO patientDTO){
        doctorService.updatePatient (patientDTO);
    }

    @DeleteMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable("id") Integer id){
        doctorService.deletePatient (id);
    }

    @GetMapping(value = "/caregiver/{id}")
    public CaregiverDTO findCaregiverById(@PathVariable("id") Integer id){
        CaregiverDTO c =  doctorService.findCaregiverById(id);
        return c;
    }

    @GetMapping("/allCaregivers")
    public List<CaregiverDTO> findAllCaregivers(){
        return doctorService.findAllCaregivers ();
    }

    @PostMapping("/newCaregiver")
    public void insertCaregiver(@RequestBody CaregiverDTO caregiverDTO){
        doctorService.insertCaregiver (caregiverDTO);
    }

    @PutMapping("/updateCaregiver")
    public void updateCaregiver(@RequestBody CaregiverDTO caregiverDTO){
        System.out.println (caregiverDTO.toString ());

        doctorService.updateCaregiver (caregiverDTO);
    }

    @DeleteMapping("/caregiver/delete/id/{id}")
    public void deleteCaregiver(@PathVariable("id") Integer id){
        doctorService.deleteCaregiver (id);
    }


    @GetMapping(value = "/medication/{id}")
    public MedicationDTO findMedicationById(@PathVariable("id") Integer id){
        return doctorService.findMedicationById (id);
    }

    @GetMapping("/allMedications")
    public List<MedicationDTO> findAllMedications(){
        List<MedicationDTO> meds = doctorService.findAllMedications ();
        return meds;
    }

    @PostMapping("/newMedication")
    public void insertMedication(@RequestBody MedicationDTO medicationDTO){
        doctorService.insertMedication (medicationDTO);
    }

    @PutMapping("/updateMedication")
    public void updateMedication(@RequestBody MedicationDTO medicationDTO){
        doctorService.updateMedication (medicationDTO);
    }

    @DeleteMapping("/medication/idToDelete/{id}")
    public void deleteMedication(@PathVariable("id") Integer id){
        doctorService.deleteMedication (id);
    }


    @PostMapping("/newMedicationPlan")
    public void insertMedicationPlan(@RequestBody MedicationPlanDTO medicationPlanDTO) {
        doctorService.insertMedicationPlan (medicationPlanDTO);
    }
}
