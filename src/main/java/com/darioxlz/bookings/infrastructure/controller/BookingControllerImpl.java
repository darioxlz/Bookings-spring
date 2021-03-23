package com.darioxlz.bookings.infrastructure.controller;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import com.darioxlz.bookings.application.port.input.IBookingController;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingControllerImpl implements IBookingController {
    private final IBookingService service;

    @Autowired
    public BookingControllerImpl(IBookingService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<BookingResponseDTO>> find() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<BookingResponseDTO> findById(@PathVariable("id") int id) {
        return service.findById(id).map(booking -> new ResponseEntity<>(booking, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<BookingResponseDTO> save(@Valid BookingRequestDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }
}
