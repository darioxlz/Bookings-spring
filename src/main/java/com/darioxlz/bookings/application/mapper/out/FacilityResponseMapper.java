package com.darioxlz.bookings.application.mapper.out;

import com.darioxlz.bookings.application.dto.out.FacilityResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IFacilityService;
import com.darioxlz.bookings.domain.entity.Facility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IFacilityService.class})
public interface FacilityResponseMapper {
    @Mappings({
            @Mapping(target = "facid", source = "entity.facilityId"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "guestcost", source = "entity.guestCost"),
            @Mapping(target = "membercost", source = "entity.memberCost"),
            @Mapping(target = "initialoutlay", source = "entity.initialOutlay"),
            @Mapping(target = "monthlymaintenance", source = "entity.monthlyMaintenance")
    })
    FacilityResponseDTO FacilityToFacilityResponseDTO(Facility entity);

    List<FacilityResponseDTO> FacilitiesToFacilityResponseDTO(List<Facility> facilities);
}
