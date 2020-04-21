package com.utcn.soapApi.controller;

import com.utcn.soapApi.dtos.*;
import com.utcn.soapApi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/soapDoctor")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    DoctorController(DoctorService doctorService) throws MalformedURLException {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/patient/{idPatient}")
    public PatientDTO getPatientDetails(@PathVariable("idPatient") Integer id){
        PatientDTO patient =  doctorService.findPatientDetails(id);
        //System.out.println(patient);
        return patient;
    }

    @GetMapping(value = "/patient/{idPatient}/activities")
    public List<MonitoredDataDTO> getActivities(@PathVariable("idPatient") Integer id){
      List<MonitoredDataDTO> monitoredDataDTOS =  doctorService.getActivities(id);
       // monitoredDataDTOS.forEach(System.out::println);
        return monitoredDataDTOS;
    }

    @GetMapping(value = "/pills/patient/{idPatient}/on/{date}")
    public List<MonitoredPillDTO> getMonitoredPills(@PathVariable("idPatient") Integer id, @PathVariable("date") String date){
        List<MonitoredPillDTO> monitoredDataDTOS =  doctorService.getMonitoredPills(id, date);
        //monitoredDataDTOS.forEach(System.out::println);
        return monitoredDataDTOS;
    }

    ///patient/' + id + "/activity/date/" + date

    @GetMapping(value = "/patient/{idPatient}/activity/date/{date}")
    public List<ActivityStatus> getActivityStatus(@PathVariable("idPatient") Integer id, @PathVariable("date") String date){
        List<ActivityStatus> monitoredData =  doctorService.getActivityOnDate(id , date);
        return monitoredData;
    }

    @PostMapping(value = "/recommendation")
    public void insertRecommendation(@RequestBody RecommendationDTO recommendationDTO){
        System.out.println("New one...." + recommendationDTO.toString());
         doctorService.newRecomd(recommendationDTO);
    }

    @GetMapping(value = "/recommendations/{idCaregiver}")
    public List<RecommendationDTO> getRecommendations(@PathVariable("idCaregiver") Integer id){
        List<RecommendationDTO> rec = doctorService.getRecommendations(id);
        rec.forEach(System.out::println);
        return rec;
    }



}
