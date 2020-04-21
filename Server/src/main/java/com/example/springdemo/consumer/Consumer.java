package com.example.springdemo.consumer;

import com.example.springdemo.controller.NotificationController;
import com.example.springdemo.services.MonitoredDataService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements MessageListener {

    @Autowired
    NotificationController notificationController;

    @Autowired
    MonitoredDataService monitoredDataService;


    @Override
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void onMessage(Message message) {
        try {
            Thread.sleep (1000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        String response = new String (message.getBody ());

        try {
            if(message.getBody () != null) {
                System.out.println (response);
                JSONObject resp = monitoredDataService.processActivity ((String) new JSONParser (JSONParser.MODE_PERMISSIVE).parse (response));
                if(resp.getAsString ("message") != null) {
                    notificationController.sendNotification (resp);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }

    }
}
