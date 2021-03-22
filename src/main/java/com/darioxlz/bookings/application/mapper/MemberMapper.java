package com.darioxlz.bookings.application.mapper;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.domain.entity.Member;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookingMapper.class})
public interface MemberMapper {
    @Mappings({
            @Mapping(target = "memid", source = "member.memberId"),
            @Mapping(target = "surname", source = "member.surname"),
            @Mapping(target = "firstname", source = "member.firstname"),
            @Mapping(target = "address", source = "member.address"),
            @Mapping(target = "zipcode", source = "member.zipcode"),
            @Mapping(target = "telephone", source = "member.telephone"),
            @Mapping(target = "recommendedby", source = "member.recommendedBy"),
            @Mapping(target = "joindate", source = "member.joinDate", dateFormat = "dd-MM-yyyy")
    })
    MemberRequestDTO MemberToDTO(Member member);

    List<MemberRequestDTO> MembersToDTO(List<Member> members);

    @InheritInverseConfiguration
    @Mapping(target = "bookings", ignore = true)
    Member MemberDTOtoMember(MemberRequestDTO dto);
}
