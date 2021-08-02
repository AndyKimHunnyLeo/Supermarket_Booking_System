package com.polarmushroom.customer;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;
import com.polarmushroom.domain.customer.Customer;
import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.service.CustomerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    CustomerServiceImpl customerServiceImpl;
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
        customerServiceImpl.join(customer);

        //Then
        Customer findCustomer = customerServiceImpl.findWithId(1L).get();
        assertEquals(customer.getName(), findCustomer.getName());


    }

    @Test
    void validation()throws Exception {
        //Given
        Customer customer1 = new Customer(1L, "memberA","022-350-6196");
        Customer customer2 = new Customer(2L, "memberA","022-628-6867");

        //When
        customerServiceImpl.join(customer1);


        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> customerServiceImpl.join(customer2));//should throw an error
        assertThat(e.getMessage()).isEqualTo("Name can not be same");
    }

    @Test
    void findName(){
        //Given
        Customer customer = new Customer(1L, "memberA","022-350-6196");

        //When
        customerServiceImpl.join(customer);

        //Then
        Customer findCustomer = customerServiceImpl.findWithName("memberA").get();
        assertEquals(customer.getName(), findCustomer.getName());
    }

    @Test
    void addBooking(){
        //Given
        Customer customer = new Customer(1L, "memberA","022-350-6196");
        Booking booking = new Booking(1L, 2, Days.THURSDAY);

        //When
        customerServiceImpl.join(customer);
        customerServiceImpl.addBooking(booking);

        //Then
        Customer findCustomer = customerServiceImpl.findWithId(1L).get();
        assertEquals(true, findCustomer.getBooking().contains(booking));
    }

    @Test
    void deleteBooking(){
        //Given
        Customer customer = new Customer(1L, "memberA","022-350-6196");
        Booking booking = new Booking(1L, 2, Days.THURSDAY);

        //When
        customerServiceImpl.join(customer);
        customerServiceImpl.addBooking(booking);
        customerServiceImpl.removeBooking(booking);

        //Then
        Customer findCustomer = customerServiceImpl.findWithId(1L).get();

        assertEquals(false ,findCustomer.getBooking().contains(booking) );
    }
}
