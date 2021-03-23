package com.darioxlz.bookings.application.mapper.in;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.domain.entity.Facility;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BookingRequestMapper.class})
public interface FacilityRequestMapper {
    @Mappings({
            @Mapping(target = "name", source = "dto.name"),
            @Mapping(target = "memberCost", source = "dto.membercost"),
            @Mapping(target = "guestCost", source = "dto.guestcost"),
            @Mapping(target = "initialOutlay", source = "dto.initialoutlay"),
            @Mapping(target = "monthlyMaintenance", source = "dto.monthlymaintenance"),
            @Mapping(target = "bookings", ignore = true),
            @Mapping(target = "facilityId", ignore = true)
    })
    Facility FacilityRequestDTOtoFacility(FacilityRequestDTO dto);

    @InheritInverseConfiguration
    FacilityRequestDTO FacilityToFacilityRequestDTO(Facility facility);
}
