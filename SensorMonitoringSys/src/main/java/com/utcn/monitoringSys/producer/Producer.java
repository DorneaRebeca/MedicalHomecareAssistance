package com.utcn.monitoringSys.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value ("${rabbitmq.exchange}")
    private String exchange;

    @Value ("${rabbitmq.routingkey}")
    private String routingKey;

    public void produceMessages(String msg) {
        amqpTemplate.convertAndSend (exchange, routingKey, msg);
        //System.out.println ("Sent message : " + msg);
    }

}
