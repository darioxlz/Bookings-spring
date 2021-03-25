package com.darioxlz.bookings.application.port.output.crud;

import com.darioxlz.bookings.domain.entity.Facility;
import org.springframework.data.repository.CrudRepository;

public interface IFacilityCrudRepository extends CrudRepository<Facility, Integer> {
    Integer deleteByFacilityId(int facilityId);
}
