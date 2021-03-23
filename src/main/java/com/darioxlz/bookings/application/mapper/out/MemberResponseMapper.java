package com.darioxlz.bookings.application.mapper.out;

import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IMemberService;
import com.darioxlz.bookings.domain.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IMemberService.class})
public interface MemberResponseMapper {
    @Mappings({
            @Mapping(target = "memid", source = "entity.memberId"),
            @Mapping(target = "surname", source = "entity.surname"),
            @Mapping(target = "firstname", source = "entity.firstname"),
            @Mapping(target = "address", source = "entity.address"),
            @Mapping(target = "zipcode", source = "entity.zipcode"),
            @Mapping(target = "telephone", source = "entity.telephone"),
            @Mapping(target = "joindate", source = "entity.joinDate"),
            @Mapping(target = "recommendedby", source = "entity.recommendedBy")
    })
    MemberResponseDTO MemberToMemberResponseDTO(Member entity);

    List<MemberResponseDTO> MembersToMemberResponseDTO(List<Member> members);
}
