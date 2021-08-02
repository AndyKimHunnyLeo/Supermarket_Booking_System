package com.polarmushroom.domain.customer;

import com.polarmushroom.domain.booking.Booking;

public class Customer {
    private Long id;
    private String name;
    private String phone;
    private Booking[] booking;

    public Customer(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Booking[] getBooking() {
        return booking;
    }

    public void setBooking(Booking[] booking) {
        if(booking.length < 8){
            this.booking = booking;
        }
    }
}
