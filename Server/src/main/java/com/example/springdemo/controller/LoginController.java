package com.example.springdemo.controller;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.services.CaregiverService;
import com.example.springdemo.services.DoctorService;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login")
public class LoginController {

    private final CaregiverService caregiverService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public LoginController(CaregiverService caregiverService, DoctorService doctorService, PatientService patientService) {
        this.caregiverService = caregiverService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @PostMapping("/submit")
    public Object loginFunction(@RequestBody String email, @RequestBody String password, @RequestBody Integer choice) throws Exception {
        System.out.println ("In login....");
        try {
            switch (choice) {
                case 1: {
                    PatientDTO patientDTO = (PatientDTO) patientService.login (email, password);
                    if (patientDTO != null) {
                        return patientDTO;
                    }
                    break;
                }
                case 2: {
                    CaregiverDTO caregiverDTO = (CaregiverDTO) caregiverService.login (email, password);
                    if (caregiverDTO != null) {
                        return caregiverDTO;
                    }
                    break;
                }
                case 3: {
                    DoctorDTO doctorDTO = (DoctorDTO) doctorService.login (email, password);
                    if (doctorDTO != null) {
                        return doctorDTO;
                    }
                    break;
                }
                default: {
                    System.out.println ("Wrong choice man!!!");
                    throw new Exception ("Something went truly wrong!!!");
                }
            }
        }catch (Exception e) {
            System.out.println (e.getMessage ());
        }
        return new ModelAndView("/login");
    }


}
