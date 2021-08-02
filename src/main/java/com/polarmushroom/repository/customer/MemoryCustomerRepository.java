package com.polarmushroom.repository.customer;


import com.polarmushroom.domain.customer.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryCustomerRepository implements CustomerRepository {

    private static Map<Long, Customer> store = new HashMap<>();

    @Override
    public void save(Customer customer) {
        store.put(customer.getId(), customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Customer> findAll() {
        return store.values().stream().collect(Collectors.toList());
    }
}
