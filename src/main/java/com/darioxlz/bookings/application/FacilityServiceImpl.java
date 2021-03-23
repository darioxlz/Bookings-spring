package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.mapper.in.FacilityRequestMapper;
import com.darioxlz.bookings.application.mapper.out.FacilityResponseMapper;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import com.darioxlz.bookings.domain.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {
    private final IFacilityRepository repository;
    private final FacilityRequestMapper requestMapper;
    private final FacilityResponseMapper responseMapper;

    @Autowired
    public FacilityServiceImpl(IFacilityRepository repository, FacilityRequestMapper requestMapper, FacilityResponseMapper responseMapper) {
        this.repository = repository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public List<FacilityResponseDTO> find() {
        return responseMapper.FacilitiesToFacilityResponseDTO(repository.find());
    }

    @Override
    public Optional<FacilityResponseDTO> findById(int id) {
        return repository.findById(id).map(responseMapper::FacilityToFacilityResponseDTO);
    }

    @Override
    public FacilityResponseDTO save(FacilityRequestDTO dto) {
        Facility facility = repository.save(requestMapper.FacilityRequestDTOtoFacility(dto));
        return responseMapper.FacilityToFacilityResponseDTO(facility);
    }
}
