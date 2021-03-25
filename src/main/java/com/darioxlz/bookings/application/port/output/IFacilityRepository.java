package com.darioxlz.bookings.application.port.output;

import com.darioxlz.bookings.domain.entity.Facility;

import java.util.List;
import java.util.Optional;

public interface IFacilityRepository {
    List<Facility> find();

    Optional<Facility> findById(int facilityId);

    Facility save(Facility facility);

    void deleteByFacilityId(int facilityId);
}
