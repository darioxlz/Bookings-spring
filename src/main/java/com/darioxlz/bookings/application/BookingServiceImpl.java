package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import com.darioxlz.bookings.application.mapper.in.BookingRequestMapper;
import com.darioxlz.bookings.application.mapper.out.BookingResponseMapper;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import com.darioxlz.bookings.application.port.output.IBookingRepository;
import com.darioxlz.bookings.domain.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements IBookingService {
    private final IBookingRepository repository;
    private final BookingRequestMapper requestMapper;
    private final BookingResponseMapper responseMapper;

    @Autowired
    public BookingServiceImpl(IBookingRepository repository, BookingRequestMapper requestMapper, BookingResponseMapper responseMapper) {
        this.repository = repository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public List<BookingResponseDTO> find() {
        return responseMapper.BookingsToBookingResponseDTO(repository.find());
    }

    @Override
    public Optional<BookingResponseDTO> findById(int id) {
        return repository.findById(id).map(responseMapper::BookingToBookingResponseDTO);
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO dto) {
        Booking booking = repository.save(requestMapper.BookingRequestDTOtoBooking(dto));
        return responseMapper.BookingToBookingResponseDTO(booking);
    }
}
