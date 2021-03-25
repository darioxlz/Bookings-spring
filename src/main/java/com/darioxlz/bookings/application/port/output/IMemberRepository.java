package com.darioxlz.bookings.application.port.output;

import com.darioxlz.bookings.domain.entity.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberRepository {
    List<Member> find();

    List<Member> findByRecommendedBy(int memberId);

    Optional<Member> findByID(int memberId);

    Member save(Member member);

    void deleteByMemberId(int memberId);
}
