package com.darioxlz.bookings.application.port.output.crud;

import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface IMemberCrudRepository extends CrudRepository<Member, Integer> {
}
