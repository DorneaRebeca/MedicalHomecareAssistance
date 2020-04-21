package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MonitoredDataDTO;
import com.example.springdemo.entities.MonitoredData;

public class MonitoredDataBuilder {

    public static MonitoredDataDTO generateDTOFromEntity(MonitoredData monitoredData){

        return new MonitoredDataDTO(
                monitoredData.getActivity(),
                monitoredData.getStart(),
                monitoredData.getEnd(),
                PatientBuilder.generateDTOFromEntity(monitoredData.getPatient()),
                        monitoredData.getAnomaly()
        );
    }

    public static MonitoredData generateEntityFromDTO(MonitoredDataDTO monitoredData){
        return new MonitoredData(
                monitoredData.getActivity(),
                monitoredData.getStart(),
                monitoredData.getEnd(),
                PatientBuilder.generateEntityFromDTO(monitoredData.getPatient()),
                monitoredData.getAnomaly()
        );
    }

}
