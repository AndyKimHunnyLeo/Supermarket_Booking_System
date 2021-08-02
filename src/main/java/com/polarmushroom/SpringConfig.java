package com.polarmushroom;

import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CustomerService customerService(){
        return new CustomerService(customerRepository());
    }
    @Bean
    public CustomerRepository customerRepository(){
        return new MemoryCustomerRepository();
    }
}
