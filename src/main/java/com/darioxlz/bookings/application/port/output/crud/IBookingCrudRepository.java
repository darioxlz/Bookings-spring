package com.darioxlz.bookings.application.port.output.crud;

import com.darioxlz.bookings.domain.entity.Booking;
import org.springframework.data.repository.CrudRepository;

public interface IBookingCrudRepository extends CrudRepository<Booking, Integer> {
    Integer deleteByBookingId(int bookingId);
}
