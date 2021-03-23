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

@Service
public class MemberServiceImpl implements IMemberService {
    private final IMemberRepository repository;

    @Autowired
    public MemberServiceImpl(IMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MemberResponseDTO> find() {
        List<MemberResponseDTO> members = (List<MemberResponseDTO>) repository.find().stream().map(member -> {
            MemberResponseDTO dto = new MemberResponseDTO();

            dto.setMemid(member.getMemberId());
            dto.setSurname(member.getSurname());
            dto.setFirstname(member.getFirstname());
            dto.setAddress(member.getAddress());
            dto.setZipcode(member.getZipcode());
            dto.setTelephone(member.getTelephone());
            dto.setJoindate(member.getJoinDate());

            return dto;
        });

        return members;
    }

    @Override
    public Optional<MemberResponseDTO> findById(int memid) {
        MemberResponseDTO response = new MemberResponseDTO();
        Optional<Member> member = repository.findByID(memid);

        if (member.isPresent()) {
            response.setMemid(member.get().getMemberId());
            response.setSurname(member.get().getSurname());
            response.setFirstname(member.get().getFirstname());
            response.setAddress(member.get().getAddress());
            response.setZipcode(member.get().getZipcode());
            response.setTelephone(member.get().getTelephone());

            if (member.get().getRecommendedBy() != null) {
                response.setRecommendedby(member.get().getRecommendedBy().getMemberId());
            } else {
                response.setRecommendedby(null);
            }

            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public MemberResponseDTO save(MemberRequestDTO dto) {
        Member member = new Member();
        boolean recomended = false;

        member.setSurname(dto.getSurname());
        member.setFirstname(dto.getFirstname());
        member.setAddress(dto.getAddress());
        member.setZipcode(dto.getZipcode());
        member.setTelephone(dto.getTelephone());

        if (dto.getRecommendedby() != null) {
            Optional<Member> recommender = repository.findByID(dto.getRecommendedby());

            if (recommender.isPresent()) {
                member.setRecommendedBy(recommender.get());
                recomended = true;
            }
        }

        LocalDateTime fecha = LocalDateTime.now();
        member.setJoinDate(fecha);


        member = repository.save(member);

        MemberResponseDTO response = new MemberResponseDTO();
        response.setMemid(member.getMemberId());
        response.setSurname(member.getSurname());
        response.setFirstname(member.getFirstname());
        response.setAddress(member.getAddress());
        response.setZipcode(member.getZipcode());
        response.setTelephone(member.getTelephone());
        response.setJoindate(member.getJoinDate());

        if (recomended) {
            response.setRecommendedby(member.getRecommendedBy().getMemberId());
        }

        return response;
    }
}
