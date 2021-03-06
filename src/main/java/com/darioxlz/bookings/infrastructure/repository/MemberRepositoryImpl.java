package com.darioxlz.bookings.infrastructure.repository;

import com.darioxlz.bookings.application.port.output.IMemberRepository;
import com.darioxlz.bookings.application.port.output.crud.IMemberCrudRepository;
import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements IMemberRepository {
    private final IMemberCrudRepository repository;

    @Autowired
    public MemberRepositoryImpl(IMemberCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Member> find() {
        return (List<Member>) repository.findAll();
    }

    @Override
    public List<Member> findByRecommendedBy(int memberId) {
        return repository.findAllByRecommendedBy(memberId);
    }

    @Override
    public Optional<Member> findByID(int memberId) {
        return repository.findById(memberId);
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    @Transactional
    public void deleteByMemberId(int memberId) {
        repository.deleteByMemberId(memberId);
    }
}
