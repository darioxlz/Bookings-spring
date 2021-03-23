package com.darioxlz.bookings.application.mapper.out;

import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import com.darioxlz.bookings.domain.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IBookingService.class})
public interface BookingResponseMapper {
    @Mappings({
            @Mapping(target = "bookid", source = "entity.bookingId"),
            @Mapping(target = "facid", source = "entity.facility"),
            @Mapping(target = "memid", source = "entity.member"),
            @Mapping(target = "slots", source = "entity.slots"),
            @Mapping(target = "starttime", source = "entity.startTime")
    })
    BookingResponseDTO BookingToBookingResponseDTO(Booking entity);

    List<BookingResponseDTO> BookingsToBookingResponseDTO(List<Booking> bookings);
}
