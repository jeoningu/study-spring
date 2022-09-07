package hello.jigspring.repository;

import hello.jigspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {

        /*
        // 스트림
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long sum = LongStream.of(1, 3, 5, 7, 9).sum();
        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
        DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
                .average()
                .ifPresent(System.out::println);

        OptionalInt reduced =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce((a, b) -> {
                            return Integer.sum(a, b);
                        });

        List<String> list = List.of("Peter", "Thomas", "Edvard", "Gerhard");
        // print using lambda
        list.forEach(item -> System.out.println(item));
        // print using :: (method reference operator)
        list.forEach(System.out::println);*/

        return store.values().stream()
                .filter(member-> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
