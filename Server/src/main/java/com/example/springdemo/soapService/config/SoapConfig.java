package com.example.springdemo.soapService.config;

import com.example.springdemo.soapService.services.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.xml.ws.Endpoint;

@Configuration
public class SoapConfig  {

    private DoctorServiceImpl doctorService;

    @Autowired
    public SoapConfig(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @Bean
    public void startServer() {
        new Thread(() -> {
            Endpoint.publish("http://0.0.0.0:8888/ws/doctor", doctorService);
        }).start();

    }

}
