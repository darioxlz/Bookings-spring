package com.darioxlz.bookings.application.port.interactor;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.application.dto.out.MemberResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    List<MemberResponseDTO> find();

    Optional<MemberResponseDTO> findById(int id);

    MemberResponseDTO save(MemberRequestDTO dto);
}
