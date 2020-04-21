package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.RecommendationDTO;
import com.example.springdemo.entities.Recommendation;

public class RecommendationBuilder {
    public static RecommendationDTO generateDTOFromEntity(Recommendation monitoredData){

        return new RecommendationDTO(
                monitoredData.getId(),
                monitoredData.getMessage(),
                PatientBuilder.generateDTOFromEntity(monitoredData.getPatient()),
                CaregiverBuilder.generateDTOFromEntity(monitoredData.getCaregiver())
        );
    }

    public static Recommendation generateEntityFromDTO(RecommendationDTO monitoredData){
        return new Recommendation(
                monitoredData.getId(),
                monitoredData.getMessage(),
                PatientBuilder.generateEntityFromDTO(monitoredData.getPatient()),
                CaregiverBuilder.generateEntityFromDTO(monitoredData.getCaregiver())
        );
    }
}
