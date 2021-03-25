package com.darioxlz.bookings.application.port.input;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IFacilityController {
    ResponseEntity<List<FacilityResponseDTO>> find();

    ResponseEntity<FacilityResponseDTO> findById(@PathVariable("id") int id);

    ResponseEntity<FacilityResponseDTO> save(@RequestBody @Valid FacilityRequestDTO dto);

    ResponseEntity<FacilityResponseDTO> update(@PathVariable("id") int id, @RequestBody @Valid FacilityRequestDTO dto);

    ResponseEntity<FacilityResponseDTO> delete(@PathVariable("id") int id);
}
