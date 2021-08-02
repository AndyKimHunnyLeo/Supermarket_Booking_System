package com.polarmushroom;

import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CustomerServiceImpl customerService(){
        return new CustomerServiceImpl(customerRepository());
    }
    @Bean
    public CustomerRepository customerRepository(){
        return new MemoryCustomerRepository();
    }
}
