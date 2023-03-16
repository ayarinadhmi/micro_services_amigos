package com.ayari;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMqMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange,String routingKey){
        log.info("publishing to {} using routingKey {} , payload {}", exchange,routingKey,payload);
        amqpTemplate.convertAndSend(exchange,routingKey, payload);
    }
}
