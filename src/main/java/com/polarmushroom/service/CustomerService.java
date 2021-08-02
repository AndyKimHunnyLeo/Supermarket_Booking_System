package com.polarmushroom.service;

import com.polarmushroom.domain.customer.Customer;
import com.polarmushroom.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }




    //Register a user
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
            throw new IllegalStateException("Name can not be same");
        });
    }

    //Get all users
    public List<Customer> findMembers() {
        return customerRepository.findAll();
    }

    //Find a user with name
    public Optional<Customer> findOne(Long id) {
        return customerRepository.findById(id);
    }

}
