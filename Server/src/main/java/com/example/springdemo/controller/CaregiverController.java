package com.example.springdemo.controller;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.services.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/caregiver")
public class CaregiverController {

    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }

    @GetMapping(value = "/{id}")
    public CaregiverDTO findById(@PathVariable("id") Integer id){

        CaregiverDTO c = caregiverService.findUserById(id);
        System.out.println (c.toString ());
        return c;
    }

    @GetMapping(value = "/email/{email}")
    public CaregiverDTO findByEmail(@PathVariable("email") String email){
        return caregiverService.findByEmail(email);
    }

    @PutMapping()
    public Integer updateUser(@RequestBody CaregiverDTO caregiverDTO) {
        return caregiverService.update(caregiverDTO);
    }

}
