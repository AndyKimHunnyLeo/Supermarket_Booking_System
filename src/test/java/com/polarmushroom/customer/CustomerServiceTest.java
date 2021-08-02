package com.polarmushroom.customer;

import com.polarmushroom.domain.customer.Customer;
import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired CustomerService customerService;
    @Autowired CustomerRepository repository;

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    void join(){
        //Given
        Customer customer = new Customer(1L, "memberA","022-350-6196");

        //When
        customerService.join(customer);

        //Then
        Customer findCustomer = customerService.findWithId(1L).get();
        assertEquals(customer.getName(), findCustomer.getName());


    }

    @Test
    void validation()throws Exception {
        //Given
        Customer customer1 = new Customer(1L, "memberA","022-350-6196");
        Customer customer2 = new Customer(2L, "memberA","022-628-6867");

        //When
        customerService.join(customer1);


        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> customerService.join(customer2));//should throw an error
        assertThat(e.getMessage()).isEqualTo("Name can not be same");
    }

    @Test
    void findName(){
        //Given
        Customer customer = new Customer(1L, "memberA","022-350-6196");

        //When
        customerService.join(customer);

        //Then
        Customer findCustomer = customerService.findWithName("memberA").get();
        assertEquals(customer.getName(), findCustomer.getName());
    }
}
