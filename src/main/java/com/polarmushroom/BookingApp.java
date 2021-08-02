package com.polarmushroom;

import com.polarmushroom.domain.customer.Customer;
import com.polarmushroom.repository.customer.MemoryCustomerRepository;
import com.polarmushroom.service.CustomerService;

public class BookingApp {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(new MemoryCustomerRepository());
        Customer customer = new Customer(1L, "memberA","022-350-6196");
        Customer customer2 = new Customer(2L, "memberA","022-350-6196");

        customerService.join(customer);
//        customerService.join(customer2);

        Customer findMember = customerService.findOne(1L).get();
        System.out.println("customer = " + customer);
        System.out.println("customer = " + customer2.getName());

        System.out.println("findMember = " + findMember);
    }
}
