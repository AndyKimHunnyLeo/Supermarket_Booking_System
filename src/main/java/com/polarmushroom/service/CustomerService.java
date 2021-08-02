package com.polarmushroom.service;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Long join(Customer customer);
    public List<Customer> findCustomers();
    public Optional<Customer> findWithId(Long id);
    public Optional<Customer> findWithName(String name);
    public Booking addBooking(Booking booking);
    public Booking removeBooking(Booking booking);

}
