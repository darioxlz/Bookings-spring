package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;
import com.darioxlz.bookings.application.mapper.in.MemberRequestMapper;
import com.darioxlz.bookings.application.mapper.out.MemberResponseMapper;
import com.darioxlz.bookings.application.port.interactor.IMemberService;
import com.darioxlz.bookings.application.port.output.IMemberRepository;
import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements IMemberService {
    private final IMemberRepository repository;
    private final MemberRequestMapper requestMapper;
    private final MemberResponseMapper responseMapper;

    @Autowired
    public MemberServiceImpl(IMemberRepository repository, MemberResponseMapper responseMapper, MemberRequestMapper requestMapper) {
        this.repository = repository;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    @Override
    public List<MemberResponseDTO> find() {
        return responseMapper.MembersToMemberResponseDTO(repository.find());
    }

    @Override
    public Optional<MemberResponseDTO> findById(int id) {
        return repository.findByID(id).map(responseMapper::MemberToMemberResponseDTO);
    }

    @Override
    public MemberResponseDTO save(MemberRequestDTO dto) {
        Member member = repository.save(requestMapper.MemberRequestDTOtoMember(dto));
        return responseMapper.MemberToMemberResponseDTO(member);
    }
}
