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
        return null;
    }

    @Override
    public Optional<MemberResponseDTO> findById(int memid) {
        return Optional.empty();
    }

    @Override
    public MemberResponseDTO save(MemberRequestDTO dto) {
        Member member = new Member();

        member.setSurname(dto.getSurname());
        member.setFirstname(dto.getFirstname());
        member.setAddress(dto.getAddress());
        member.setZipcode(dto.getZipcode());
        member.setTelephone(dto.getTelephone());

        LocalDateTime fecha = LocalDateTime.now();
        member.setJoinDate(fecha);

        repository.save(member);

        return null;
    }
}
