package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IMemberService;
import com.darioxlz.bookings.application.port.output.IMemberRepository;
import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements IMemberService {
    private final IMemberRepository repository;

    @Autowired
    public MemberServiceImpl(IMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MemberResponseDTO> find() {
        List<Member> members = repository.find();

        return members.stream().map(MemberResponseDTO::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<MemberResponseDTO> findById(int memid) {
        Optional<Member> member = repository.findByID(memid);

        if (member.isPresent()) {
            MemberResponseDTO response = MemberResponseDTO.toDto(member.get());

            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public MemberResponseDTO save(MemberRequestDTO dto) {
        Member member = MemberResponseDTO.toMember(dto);
        boolean recomended = false;

        if (dto.getRecommendedby() != null) {
            Optional<Member> recommender = repository.findByID(dto.getRecommendedby());

            if (recommender.isPresent()) {
                member.setRecommendedBy(recommender.get());
                recomended = true;
            }
        }


        member = repository.save(member);

        return MemberResponseDTO.toDto(member);
    }

    @Override
    public MemberResponseDTO update(int id, MemberRequestDTO dto) {
        Optional<Member> member = repository.findByID(id);

        if (member.isPresent()) {
            Member entity = member.get();

            if (dto.getSurname() != null) entity.setSurname(dto.getSurname());
            if (dto.getFirstname() != null) entity.setFirstname(dto.getFirstname());
            if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
            if (dto.getTelephone() != null) entity.setTelephone(dto.getTelephone());
            if (dto.getZipcode() != null) entity.setZipcode(dto.getZipcode());

            if (dto.getRecommendedby() != null) {
                Optional<Member> recommender = repository.findByID(dto.getRecommendedby());
                if (recommender.isPresent()) entity.setRecommendedBy(recommender.get());
            }

            entity = repository.save(entity);

            return MemberResponseDTO.toDto(entity);
        } else {
            return null;
        }
    }

    @Override
    public MemberResponseDTO delete(int id) {
        Optional<Member> member = repository.findByID(id);

        if (member.isPresent()) {
            List<Member> recommendedMembers = repository.findByRecommendedBy(id);

            for (Member member1 : recommendedMembers) {
                member1.setRecommendedBy(null);
                repository.save(member1);
            }

            repository.deleteByMemberId(id);

            return MemberResponseDTO.toDto(member.get());
        } else {
            return null;
        }
    }
}
