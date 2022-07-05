package hello.jigspring.repository;

import hello.jigspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByNma(Long name);
    List<Member> findAll();
}
