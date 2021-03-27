package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import com.darioxlz.bookings.domain.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            throw new ApplicationException("No facility has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public FacilityResponseDTO save(FacilityRequestDTO dto) {
        Facility facility = FacilityResponseDTO.toFacility(dto);

        facility = repository.save(facility);

        return FacilityResponseDTO.toDTO(facility);
    }

    @Override
    public FacilityResponseDTO update(int id, FacilityRequestDTO dto) {
        Optional<Facility> facility = repository.findById(id);

        if (facility.isPresent()) {
            Facility entity = facility.get();

            if (dto.getName() != null) entity.setName(dto.getName());
            if (dto.getGuestcost() != null) entity.setGuestCost(dto.getGuestcost());
            if (dto.getMembercost() != null) entity.setMemberCost(dto.getMembercost());
            if (dto.getInitialoutlay() != null) entity.setInitialOutlay(dto.getInitialoutlay());
            if (dto.getMonthlymaintenance() != null) entity.setMonthlyMaintenance(dto.getMonthlymaintenance());

            entity = repository.save(entity);

            return FacilityResponseDTO.toDTO(entity);
        } else {
            throw new ApplicationException("No facility has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public FacilityResponseDTO delete(int id) {
        Optional<Facility> facility = repository.findById(id);

        if (facility.isPresent()) {
            repository.deleteByFacilityId(id);

            return FacilityResponseDTO.toDTO(facility.get());
        } else {
            throw new ApplicationException("No facility has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }
}
