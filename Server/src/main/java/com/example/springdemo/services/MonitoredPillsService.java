package com.example.springdemo.services;

import com.example.springdemo.dto.MonitoredPillDTO;
import com.example.springdemo.dto.builders.MonitoredPillsBuilder;
import com.example.springdemo.entities.MonitoredPill;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.MonitoredPillRepository;
import com.example.springdemo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonitoredPillsService {

    private MonitoredPillRepository monitoredPillRepo;
    private PatientRepository patientRepository;

    @Autowired
    public MonitoredPillsService(MonitoredPillRepository monitoredPillRepo,
                                 PatientRepository patientRepository) {
        this.monitoredPillRepo = monitoredPillRepo;
        this.patientRepository = patientRepository;
    }

    public List<MonitoredPillDTO> getNotTakenPills(int patientId, String date) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (!patient.isPresent() ) {
            throw new ResourceNotFoundException("Patient", "user id", patientId);
        }

        List<MonitoredPill> pills = monitoredPillRepo.findByPatientAndTakenDate(
                patient.get(),
                Date.valueOf(date));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        pills.forEach(System.out::println);

        pills = pills.stream().filter(p -> p.getStatus().equals("not taken")).collect(Collectors.toList());

        return pills.stream().map(MonitoredPillsBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }
}
