package com.darioxlz.bookings.application.mapper;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.domain.entity.Facility;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookingMapper.class})
public interface FacilityMapper {
    @Mappings({
            @Mapping(target = "facid", source = "facility.facilityId"),
            @Mapping(target = "membercost", source = "facility.memberCost"),
            @Mapping(target = "guestcost", source = "facility.guestCost"),
            @Mapping(target = "initialoutlay", source = "facility.initialOutlay"),
            @Mapping(target = "monthlymaintenance", source = "facility.monthlyMaintenance"),
    })
    FacilityRequestDTO FacilityToDTO(Facility facility);

    List<FacilityRequestDTO> FacilitiesToDTO(List<Facility> facilities);

    @InheritInverseConfiguration
    @Mapping(target = "bookings", ignore = true)
    Facility FacilityDTOtoFacility(FacilityRequestDTO dto);
}
