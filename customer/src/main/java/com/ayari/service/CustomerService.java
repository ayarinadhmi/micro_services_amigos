package com.ayari.service;

import com.ayari.NotificationRequest;
import com.ayari.FraudCheckResponse;
import com.ayari.FraudClient;
import com.ayari.NotificationClient;
import com.ayari.dto.CustomerRegistrationRequest;
import com.ayari.model.Customer;
import com.ayari.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse=      fraudClient.isFraduster(customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        notificationClient.sendNotification(
                new NotificationRequest(customer.getId(),customer.getEmail(),
                        String.format("hi %s ,  welcome to amigos code... {}", customer.getFirstName()))
        );

    }
}
