package com.darioxlz.bookings.application.port.interactor;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    List<BookingResponseDTO> find();

    Optional<BookingResponseDTO> findById(int id);

    BookingResponseDTO save(BookingRequestDTO dto);
}
