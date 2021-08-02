package com.polarmushroom.domain.bookingList;

import com.polarmushroom.domain.booking.Booking;

public class BookingList {
    private Booking[] bookingList;

    public BookingList(Booking[] bookingList) {
        this.bookingList = bookingList;
    }

    public Booking[] getBookingList() {
        return bookingList;
    }

    public void setBookingList(Booking[] bookingList) {
        this.bookingList = bookingList;
    }
}
