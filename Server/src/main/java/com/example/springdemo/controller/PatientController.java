package com.example.springdemo.controller;


import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/{id}")
    public PatientDTO findById(@PathVariable("id") Integer id){
        PatientDTO p = patientService.findUserById(id);
        System.out.println (p.toString ());
        return p;
    }

    @GetMapping("/email/{email}")
    public PatientViewDTO findByEmail(@PathVariable("email") String email){
        return patientService.findUserByEmail (email);
    }

    @GetMapping(value="/record/{idPlan}")
    public List<MedicationPlanDTO> getMedicalRecord(@PathVariable("idPlan") Integer id){
        return patientService.getMedicationPlans (id);
    }

    @PutMapping()
    public Integer updateUser(@RequestBody PatientDTO patientDTO) {
        return patientService.update(patientDTO);
    }


}
