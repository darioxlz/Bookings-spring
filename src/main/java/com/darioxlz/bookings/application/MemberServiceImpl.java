package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IMemberService;
import com.darioxlz.bookings.application.port.output.IMemberRepository;
import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}
