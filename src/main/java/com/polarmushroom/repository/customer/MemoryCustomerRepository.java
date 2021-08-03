package com.polarmushroom.repository.customer;


import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.customer.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryCustomerRepository implements CustomerRepository {

    private static Map<Long, Customer> customerStore = new HashMap<>();

    @Override
    public void save(Customer customer) {
        customerStore.put(customer.getId(), customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerStore.get(id));
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerStore.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Customer> findAll() {
        return customerStore.values().stream().collect(Collectors.toList());
    }

    @Override
    public Booking addBooking(Booking booking) {
        Customer customer = customerStore.get(booking.getCustomerId());
        customer.getBooking().add(booking);
        customerStore.put(booking.getCustomerId(), customer);
        return booking;
    }

    @Override
    public Booking deleteBooking(Booking booking) {
        Customer customer = customerStore.get(booking.getCustomerId());
        customer.getBooking().remove(booking);
        customerStore.put(booking.getCustomerId(), customer);
        return booking;
    }
    @Override
    public void clearStore() {
        customerStore.clear();
    }

}
