package com.utcn.monitoringSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utcn.monitoringSys.producer.Producer;
import com.utcn.monitoringSys.service.MonitoredDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@EnableScheduling
@CrossOrigin("http://localhost:8080")
public class RabbitController {

    @Autowired
    Producer producer;

    @Autowired
    MonitoredDataService monitoredDataService;

    @GetMapping("/send")
    public String sendMessage() {
        try {
            List<String> messages = monitoredDataService.getAllActivities ();

            messages.forEach (
                    m -> {
                        producer.produceMessages (m);
                    }
            );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return "Success transmitting";
    }


}
