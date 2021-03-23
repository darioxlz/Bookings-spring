package com.darioxlz.bookings.infrastructure.repository;

import com.darioxlz.bookings.application.port.output.IBookingRepository;
import com.darioxlz.bookings.application.port.output.crud.IBookingCrudRepository;
import com.darioxlz.bookings.domain.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements IBookingRepository {
    private final IBookingCrudRepository repository;

    @Autowired
    public BookingRepositoryImpl(IBookingCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Booking> find() {
        return (List<Booking>) repository.findAll();
    }

    @Override
    public Optional<Booking> findById(int bookingId) {
        return repository.findById(bookingId);
    }

    @Override
    public Booking save(Booking booking) {
        return repository.save(booking);
    }
}
