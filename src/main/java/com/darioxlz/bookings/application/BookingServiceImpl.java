package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import com.darioxlz.bookings.application.port.output.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements IBookingService {
    private final IBookingRepository repository;

    @Autowired
    public BookingServiceImpl(IBookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookingResponseDTO> find() {
        return null;
    }

    @Override
    public Optional<BookingResponseDTO> findById(int id) {
        return Optional.empty();
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO dto) {
        return null;
    }
}
