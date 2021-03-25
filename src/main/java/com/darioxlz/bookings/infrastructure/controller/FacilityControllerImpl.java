package com.darioxlz.bookings.infrastructure.controller;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.port.input.IFacilityController;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.infrastructure.controller.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityControllerImpl implements IFacilityController {
    private final IFacilityService service;

    @Autowired
    public FacilityControllerImpl(IFacilityService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<FacilityResponseDTO>> find() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<FacilityResponseDTO> findById(@PathVariable("id") int id) {
        return service.findById(id).map(facility -> new ResponseEntity<>(facility, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<FacilityResponseDTO> save(@Valid @RequestBody FacilityRequestDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<FacilityResponseDTO> update(@PathVariable("id") int id, @Valid FacilityRequestDTO dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<FacilityResponseDTO> delete(@PathVariable("id") int id) {
        FacilityResponseDTO responseDTO = service.delete(id);

        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("No facility with id " + id);
        }
    }
}
