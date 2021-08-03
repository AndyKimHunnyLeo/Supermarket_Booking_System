package com.polarmushroom.repository.booking;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryBookingRepository implements BookingRepository {
    private static List<Booking> supermarketStore = new ArrayList<>(192);

    @Override
    public Booking addBooking(Booking booking) {
        supermarketStore.add(booking);
        return booking;
    }

    @Override
    public Booking deleteBooking(Booking booking) {
        supermarketStore.remove(booking);
        return booking;
    }

    @Override
    public List<Booking> findBookings() {

        return supermarketStore;
    }

    @Override
    public Booking findBooking(Booking booking) {
        if (supermarketStore.contains(booking)) {
            return booking;
        }
            return null;
    }

    @Override
    public List<Booking> findBookingsWithTimeAndDays(Days days, int time) {
        return supermarketStore.stream().filter(booking -> booking.getDays().equals(days) && booking.getTime() == time).collect(Collectors.toList());
    }

    public void clearStore() {
        supermarketStore.clear();
    }
}
