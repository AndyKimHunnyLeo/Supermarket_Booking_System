package com.polarmushroom.service;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;
import com.polarmushroom.domain.customer.Customer;
import com.polarmushroom.repository.customer.CustomerRepository;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }




    //Register a user
    @Override
    public Long join(Customer customer) {
        //check duplicate name
        validateMemberName(customer);
        customerRepository.save(customer);
        return customer.getId();
    }

    //validateMember

    private void validateMemberName(Customer customer) {
        customerRepository.findByName(customer.getName()).ifPresent(member1 ->
        {
            throw new IllegalStateException("Name can not be same.");
        });
    }

    //Get all users
    @Override
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    //Find a user with id
    @Override
    public Optional<Customer> findWithId(Long id) {
        return customerRepository.findById(id);
    }

    //Find a user with name
    @Override
    public Optional<Customer> findWithName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Booking addBooking(Booking booking) {
        Customer customer = customerRepository.findById(booking.getCustomerId()).get();
        Boolean duplicateBooking = false;
        for(Booking bookingInfo : customer.getBooking()){
            if(bookingInfo.getDays() == booking.getDays()){
                duplicateBooking = true;
            }
        }

        if(!duplicateBooking){
            customerRepository.addBooking(booking);
            return booking;
        }else {
            throw new IllegalStateException("You can't book same day twice.");
        }


    }

    @Override
    public Booking removeBooking(Booking booking) {
        return customerRepository.deleteBooking(booking);
    }

}
