package com.example.springdemo.config;

import com.example.springdemo.entities.Medication;
import com.example.springdemo.services.MedicationDispenserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    private MedicationDispenserService medicationDispenserService;

    public GrpcConfig(MedicationDispenserService medicationDispenserService) {
        this.medicationDispenserService = medicationDispenserService;
    }

    @Bean
    public void grpcServerStart() {
        System.out.println("HElooooooo");
        GrpcThread newThr = new GrpcThread(medicationDispenserService);
        newThr.start();
    }
}
