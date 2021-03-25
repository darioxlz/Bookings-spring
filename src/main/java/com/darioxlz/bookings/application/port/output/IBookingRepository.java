package com.darioxlz.bookings.application.port.output;

import com.darioxlz.bookings.domain.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository {
    List<Booking> find();

    Optional<Booking> findById(int bookingId);

    Booking save(Booking booking);

    void deleteByBookingId(int bookingId);
}
