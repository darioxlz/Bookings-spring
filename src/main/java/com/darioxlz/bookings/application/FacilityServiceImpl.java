package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import com.darioxlz.bookings.domain.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl implements IFacilityService {
    private final IFacilityRepository repository;

    @Autowired
    public FacilityServiceImpl(IFacilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FacilityResponseDTO> find() {
        return repository.find().stream().map(FacilityResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<FacilityResponseDTO> findById(int id) {
        Optional<Facility> facility = repository.findById(id);

        if (facility.isPresent()) {
            FacilityResponseDTO response = FacilityResponseDTO.toDTO(facility.get());

            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public FacilityResponseDTO save(FacilityRequestDTO dto) {
        Facility facility = FacilityResponseDTO.toFacility(dto);

        facility = repository.save(facility);

        return FacilityResponseDTO.toDTO(facility);
    }
}
