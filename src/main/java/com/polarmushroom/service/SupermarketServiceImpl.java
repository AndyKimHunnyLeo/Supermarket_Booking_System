package com.polarmushroom.service;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;
import com.polarmushroom.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SupermarketServiceImpl implements SupermarketService {
    private BookingRepository bookingRepository;

    @Autowired
    public SupermarketServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Booking addBooking(Booking booking) {
        validateBooking(booking);
        return bookingRepository.addBooking(booking);
    }

    @Override
    public Booking removeBooking(Booking booking) {
        return bookingRepository.deleteBooking(booking);
    }

    @Override
    public List<Booking> findBookings() {

        return bookingRepository.findBookings();
    }

    @Override
    public Booking findBooking(Booking booking) {
        return bookingRepository.findBooking(booking);
    }

    @Override
    public List<Booking> findBookingsWithTimeAndDays(Days days, int time) {
        return bookingRepository.findBookingsWithTimeAndDays(days, time);
    }

    private void validateBooking(Booking booking) {
        for (Booking book : bookingRepository.findBookings()){
            System.out.println("book.toString() = " + book.toString());
            if(book.getCustomerId().equals(booking.getCustomerId()) && book.getDays().equals(booking.getDays())){
                throw new IllegalStateException("One customer can make only one booking per day.");

            }
        }
    }
}
