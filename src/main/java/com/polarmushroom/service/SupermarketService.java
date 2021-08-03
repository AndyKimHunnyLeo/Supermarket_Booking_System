package com.polarmushroom.service;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;

import java.util.List;

public interface SupermarketService {
    public Booking addBooking(Booking booking);
    public Booking removeBooking(Booking booking);
    public List<Booking> findBookings();
    public Booking findBooking(Booking booking);
    public List<Booking> findBookingsWithTimeAndDays(Days days,int time);



}
