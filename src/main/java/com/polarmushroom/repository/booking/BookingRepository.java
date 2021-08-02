package com.polarmushroom.repository.booking;

import com.polarmushroom.domain.booking.Booking;

public interface BookingRepository {
    Booking addBooking(Booking booking);
}
