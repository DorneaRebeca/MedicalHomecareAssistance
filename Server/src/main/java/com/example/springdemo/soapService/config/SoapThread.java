package com.example.springdemo.soapService.config;

import com.example.springdemo.soapService.services.DoctorServiceImpl;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

public class SoapThread extends Thread {

    private DoctorServiceImpl doctorService;

    public SoapThread(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public void run() {
        Endpoint.publish("http://localhost:9999/ws/doctor", doctorService);

    }
}
