package com.polarmushroom;

import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CustomerService CustomerRepository(){
        return new CustomerService(memoryCustomerRepository());
    }
    @Bean
    public CustomerRepository memoryCustomerRepository(){
        return new MemoryCustomerRepository();
    }
}
