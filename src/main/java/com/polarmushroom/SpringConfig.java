package com.polarmushroom;

import com.polarmushroom.repository.booking.BookingRepository;
import com.polarmushroom.repository.booking.MemoryBookingRepository;
import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerService;
import com.polarmushroom.service.CustomerServiceImpl;
import com.polarmushroom.service.SupermarketService;
import com.polarmushroom.service.SupermarketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CustomerServiceImpl customerService() {
        return new CustomerServiceImpl(customerRepository());
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new MemoryCustomerRepository();
    }

    @Bean
    public SupermarketService supermarketService() {
        return new SupermarketServiceImpl(bookingRepository());
    }

    @Bean
    BookingRepository bookingRepository() {
        return new MemoryBookingRepository();
    }

}
