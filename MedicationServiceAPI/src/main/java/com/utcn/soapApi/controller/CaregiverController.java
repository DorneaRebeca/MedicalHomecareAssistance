package com.utcn.soapApi.controller;

import com.utcn.soapApi.dtos.RecommendationDTO;
import com.utcn.soapApi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/caregiver")
public class CaregiverController {

    private DoctorService doctorService;

    @Autowired
    public CaregiverController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping(value = "/recommendations/{idCaregiver}")
    public List<RecommendationDTO> getActivities(@PathVariable("idCaregiver") Integer id){
        List<RecommendationDTO> rec = doctorService.getRecommendations(id);
        rec.forEach(System.out::println);
        return rec;
    }

}
