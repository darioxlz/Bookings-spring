package com.darioxlz.bookings.infrastructure.repository;

import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import com.darioxlz.bookings.application.port.output.crud.IFacilityCrudRepository;
import com.darioxlz.bookings.domain.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class FacilityRepositoryImpl implements IFacilityRepository {
    private final IFacilityCrudRepository repository;

    @Autowired
    public FacilityRepositoryImpl(IFacilityCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Facility> find() {
        return (List<Facility>) repository.findAll();
    }

    @Override
    public Optional<Facility> findById(int facilityId) {
        return repository.findById(facilityId);
    }

    @Override
    public Facility save(Facility facility) {
        return repository.save(facility);
    }

    @Override
    @Transactional
    public void deleteByFacilityId(int facilityId) {
        repository.deleteByFacilityId(facilityId);
    }
}
