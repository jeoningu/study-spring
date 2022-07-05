package hello.jigspring.repository;

import hello.jigspring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {


    // 동시성 문제로 HashMap 대신 ConcurrentHashMap을 사용해야 함. 나중에 적용해볼까?
    public static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제로 HashMap 대신 AtomicLong 을 사용해야 함. 나중에 적용해볼까?
    public static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }


    //여기부터 할 차례~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByNma(Long name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
