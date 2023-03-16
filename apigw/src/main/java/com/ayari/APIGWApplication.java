package com.ayari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class APIGWApplication {

    public static void main(String[] args){
        SpringApplication.run(APIGWApplication.class,args);
    }
}
