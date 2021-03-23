package com.darioxlz.bookings.application.port.input;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IMemberController {
    ResponseEntity<List<MemberResponseDTO>> find();

    ResponseEntity<MemberResponseDTO> findById(@PathVariable("id") int id);

    ResponseEntity<MemberResponseDTO> save(@RequestBody @Valid MemberRequestDTO dto);
}
