package com.darioxlz.bookings.application.port.input;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IBookingController {
    ResponseEntity<List<BookingResponseDTO>> find();

    ResponseEntity<BookingResponseDTO> findById(@PathVariable("id") int id);

    ResponseEntity<BookingResponseDTO> save(@RequestBody @Valid BookingRequestDTO dto);
}
