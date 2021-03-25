package com.darioxlz.bookings.application.port.output.crud;

import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMemberCrudRepository extends CrudRepository<Member, Integer> {
    @Query(value = "SELECT * FROM members WHERE recommendedby = ?1", nativeQuery = true)
    List<Member> findAllByRecommendedBy(int recommendedBy);

    Integer deleteByMemberId(int memberId);
}
