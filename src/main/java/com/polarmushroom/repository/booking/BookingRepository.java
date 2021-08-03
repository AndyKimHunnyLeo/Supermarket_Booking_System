package com.polarmushroom.repository.booking;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;

import java.util.List;

public interface BookingRepository {
     Booking addBooking(Booking booking);
     Booking deleteBooking(Booking booking);
     List<Booking> findBookings();
     Booking findBooking(Booking booking);
     List<Booking> findBookingsWithTimeAndDays(Days days,int time);
}
