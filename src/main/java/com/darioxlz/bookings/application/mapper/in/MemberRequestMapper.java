package com.darioxlz.bookings.application.mapper.in;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import com.darioxlz.bookings.domain.entity.Member;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BookingRequestMapper.class, IBookingService.class})
public interface MemberRequestMapper {
    @Mappings({
            @Mapping(target = "surname", source = "dto.surname"),
            @Mapping(target = "firstname", source = "dto.firstname"),
            @Mapping(target = "address", source = "dto.address"),
            @Mapping(target = "zipcode", source = "dto.zipcode"),
            @Mapping(target = "telephone", source = "dto.telephone"),
            @Mapping(target = "joinDate", source = "dto.joindate"),
            @Mapping(target = "recommendedBy", source = "dto.recommendedby"),
            @Mapping(target = "bookings", ignore = true),
            @Mapping(target = "memberId", ignore = true)
    })
    Member MemberRequestDTOtoMember(MemberRequestDTO dto);
}
