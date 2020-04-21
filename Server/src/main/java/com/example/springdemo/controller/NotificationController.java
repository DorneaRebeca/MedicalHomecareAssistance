package com.example.springdemo.controller;

import com.example.springdemo.entities.MonitoredData;
import net.minidev.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("http://localhost:4200")
public class NotificationController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/send/message")
    public JSONObject sendNotification(JSONObject message) {
        messagingTemplate.convertAndSend("/chat/"+message.getAsString ("caregiverID"),message);
        return message;
    }

    @MessageExceptionHandler
    public String handleException(Throwable exception) {
        messagingTemplate.convertAndSend("/errors", exception.getMessage());
        return exception.getMessage();
    }

}
