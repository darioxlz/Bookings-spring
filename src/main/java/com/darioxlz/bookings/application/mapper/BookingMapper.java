package com.darioxlz.bookings.application.mapper;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.domain.entity.Booking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MemberMapper.class, FacilityMapper.class})
public interface BookingMapper {
    @Mappings({
            @Mapping(target = "bookid", source = "booking.bookingId"),
            @Mapping(target = "slots", source = "booking.slots"),
            @Mapping(target = "starttime", source = "booking.startTime")
    })
    BookingRequestDTO BookingToDTO(Booking booking);

    List<BookingRequestDTO> BookingsToDTO(List<Booking> bookings);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "member", ignore = true),
            @Mapping(target = "facility", ignore = true)
    })
    Booking BookingDTOtoBooking(BookingRequestDTO dto);
}
