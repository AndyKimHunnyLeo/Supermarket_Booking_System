package com.polarmushroom.domain.supermarket;

import com.polarmushroom.domain.booking.Booking;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private List<Booking> bookingList = new ArrayList<>(192);

    public Supermarket(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }


}
