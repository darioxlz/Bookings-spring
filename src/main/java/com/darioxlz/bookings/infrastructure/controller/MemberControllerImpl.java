package com.darioxlz.bookings.infrastructure.controller;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.port.input.IMemberController;
import com.darioxlz.bookings.application.port.interactor.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberControllerImpl implements IMemberController {
    private final IMemberService service;

    @Autowired
    public MemberControllerImpl(IMemberService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<MemberResponseDTO>> find() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<MemberResponseDTO> findById(@PathVariable("id") int id) {
        return service.findById(id).map(member -> new ResponseEntity<>(member, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<MemberResponseDTO> save(@Valid @RequestBody MemberRequestDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }
}
