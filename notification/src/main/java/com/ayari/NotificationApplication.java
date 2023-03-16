package com.ayari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMqMessageProducer producer, NotificationConfig notificationConfig){
        return args -> {
            producer.publish("foo", notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRouting());
        };
    }

}
