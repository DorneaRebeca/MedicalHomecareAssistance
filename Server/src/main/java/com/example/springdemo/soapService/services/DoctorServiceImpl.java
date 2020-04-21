package com.example.springdemo.soapService.services;

import com.example.springdemo.dto.*;
import com.example.springdemo.dto.builders.MonitoredPillsBuilder;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.services.MonitoredPillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springdemo.services.DoctorService;

import javax.jws.WebService;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

@Service
@WebService(name = "DoctorSoapService", endpointInterface = "com.example.springdemo.soapService.services.DoctorSoapService")
public class DoctorServiceImpl implements DoctorSoapService{

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MonitoredPillsService monitoredPillsService;

    @Override
    public DoctorDTO getDoctor(int id) {

        return doctorService.findById(id);
    }

    @Override
    public DoctorDTO login(String email, String password) {
        try {

            return doctorService.login(email,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<PatientDTO> getAllPatients() {
        return (ArrayList<PatientDTO>) doctorService.findAllPatients();
    }

    @Override
    public PatientDTO getPatientDetails(int id) {
        System.out.println("ana are mere"+id);
        return doctorService.findPatientById(id);
    }

    @Override
    public ActivitiesListDTO getPatientActivities(int id) {
        List<MonitoredDataDTO> data = doctorService.getPatientActivities(doctorService.findPatientById(id));
        data.forEach(System.out::println);
        return new ActivitiesListDTO(data);
    }

    @Override
    public MonitoredPillsList getNotTakenPills(int patientID, String date) {
        return new MonitoredPillsList(monitoredPillsService.getNotTakenPills(patientID, date));
    }

    @Override
    public ActivitiesListDTO getActivityOnDate(int patientID, String date) {
        PatientDTO patientDTO = doctorService.findPatientById(patientID);

        return new ActivitiesListDTO(doctorService.getActivitiesOnDate(patientDTO, date));
    }

    @Override
    public String newRecommendation(RecommendationDTO recommendationDTO) {
        doctorService.insertRecommendation(recommendationDTO);
        System.out.println("Doooone....>:D<");
        return "Action completed";
    }

    @Override
    public RecommendationListDTO getRecommendations(int caregiverID) {

        return new RecommendationListDTO(doctorService.getCaregiverRecommendations(caregiverID));
    }


}
