package com.polarmushroom.booking;

import com.polarmushroom.domain.booking.Booking;
import com.polarmushroom.domain.booking.Days;
import com.polarmushroom.repository.booking.MemoryBookingRepository;

import com.polarmushroom.service.SupermarketServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BookingServiceImplTest {
    @Autowired
    SupermarketServiceImpl supermarketService;
    @Autowired
    MemoryBookingRepository repository;

    @AfterEach
     void afterEach() {
        repository.clearStore();
    }

    @Test
     void addBooking(){
        //Given
        Booking booking = new Booking(1L, 2, Days.THURSDAY);

        //When
        supermarketService.addBooking(booking);

        //Then
        Booking findBooking = supermarketService.findBooking(booking);
        assertEquals(booking, findBooking);
    }
    @Test
    void addDuplicateBooking() {
        //Given
        Booking booking1 = new Booking(1L, 2, Days.THURSDAY);
        Booking booking2 = new Booking(1L, 4, Days.THURSDAY);


        //When
        supermarketService.addBooking(booking1);

        //Then
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> supermarketService.addBooking(booking2));//should throw an error
        assertThat(e.getMessage()).isEqualTo("One customer can make only one booking per day.");
    }
    @Test
    void deleteBooking(){
        //Given
        Booking booking = new Booking(1L, 2, Days.THURSDAY);

        //When
        supermarketService.addBooking(booking);
        supermarketService.removeBooking(booking);

        //Then
        Booking findBooking = supermarketService.findBooking(booking);
        assertEquals(null ,findBooking );

    }

    @Test
    void findBookingAtATime(){
        //Given
        Booking booking1 = new Booking(1L, 2, Days.THURSDAY);
        Booking booking2 = new Booking(2L, 2, Days.THURSDAY);
        Booking booking3 = new Booking(3L, 2, Days.THURSDAY);

        //When
        supermarketService.addBooking(booking1);
        supermarketService.addBooking(booking2);
        supermarketService.addBooking(booking3);

        //Then
        List<Booking> bookingTestCase = new ArrayList<>();
        bookingTestCase.add(booking1);
        bookingTestCase.add(booking2);
        bookingTestCase.add(booking3);

        List<Booking> bookingInDB = supermarketService.findBookingsWithTimeAndDays(Days.THURSDAY, 2);
        assertEquals(bookingTestCase ,bookingInDB );
    }

}
