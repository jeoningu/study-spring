package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// spring data jpaRepository가 MemberRepository의 구현체(빈)를 만들어준다.
// springConfing.java에서 MemberRepository 빈을 주입받게 설정한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    @Override
    Optional<Member> findByName(String name);
}
