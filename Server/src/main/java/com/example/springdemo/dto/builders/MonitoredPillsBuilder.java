package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MonitoredPillDTO;
import com.example.springdemo.entities.MonitoredPill;

import java.sql.Date;


public class MonitoredPillsBuilder {

    public static MonitoredPillDTO generateDTOFromEntity(MonitoredPill monitoredData){

        return new MonitoredPillDTO(
                monitoredData.getId(),
                monitoredData.getTakenDate().toString(),
                monitoredData.getStatus(),
                PatientBuilder.generateDTOFromEntity(monitoredData.getPatient()),
                MedicationBuilder.generateDTOFromEntity(monitoredData.getMedication())
        );
    }

    public static MonitoredPill generateEntityFromDTO(MonitoredPillDTO monitoredData){
        return new MonitoredPill(
                monitoredData.getId(),
                Date.valueOf(monitoredData.getTakenDate()),
                monitoredData.getStatus(),
                PatientBuilder.generateEntityFromDTO(monitoredData.getPatient()),
                MedicationBuilder.generateEntityFromDTO(monitoredData.getMedication())
        );
    }

}
