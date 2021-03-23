package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {
    private final IFacilityRepository repository;

    @Autowired
    public FacilityServiceImpl(IFacilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FacilityResponseDTO> find() {
        return null;
    }

    @Override
    public Optional<FacilityResponseDTO> findById(int id) {
        return Optional.empty();
    }

    @Override
    public FacilityResponseDTO save(FacilityRequestDTO dto) {
        return null;
    }
}
