package com.darioxlz.bookings.application.mapper.in;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.domain.entity.Booking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MemberRequestMapper.class, FacilityRequestMapper.class})
public interface BookingRequestMapper {
    @Mappings({
            @Mapping(target = "facility", source = "dto.facid"),
            @Mapping(target = "member", source = "dto.memid"),
            @Mapping(target = "startTime", source = "dto.starttime"),
            @Mapping(target = "slots", source = "dto.slots"),
            @Mapping(target = "bookingId", ignore = true)
    })
    Booking BookingRequestDTOtoBooking(BookingRequestDTO dto);
}
