package com.darioxlz.bookings.application.port.interactor;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<FacilityResponseDTO> find();

    Optional<FacilityResponseDTO> findById(int id);

    FacilityResponseDTO save(FacilityRequestDTO dto);
}
