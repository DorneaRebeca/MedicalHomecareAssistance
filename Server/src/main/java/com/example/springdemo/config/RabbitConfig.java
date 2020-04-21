package com.example.springdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    @Bean
    Queue queue() {
        return new Queue (queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange (exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind (queue).to (directExchange).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return  new Jackson2JsonMessageConverter ();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory  connectionFactory) {
        final RabbitTemplate rabbitTemplate =  new RabbitTemplate (connectionFactory);
        System.out.println("in rabbit");
        rabbitTemplate.setMessageConverter (jsonMessageConverter ());
        return rabbitTemplate;
    }

}
