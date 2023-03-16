package com.ayari.controller;


import com.ayari.dto.CustomerRegistrationRequest;
import com.ayari.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {


    @PostMapping("/register")
    public void registerCustomers(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("new customer registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
