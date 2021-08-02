package com.polarmushroom.repository.customer;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save (Customer customer);

    Optional<Customer> findById(Long id);

    Optional<Customer> findByName(String name);

    List<Customer> findAll();

    Booking addBooking(Booking booking);

    void clearStore();

    Booking deleteBooking(Booking booking);
}
