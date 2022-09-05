package hello.jigspring.repository;

import hello.jigspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemerRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 테스트 메서드들은 의존관계를 가지지 않고 설계돼야 한다.
    // 각 테스트 메서드가 실행되는 순서는 보장되지 않는다.
    // 그럼으로 테스트 메서드가 실행되고 끝날 때마다 repository에 저장된 데이터를 지워주면 된다.
    // @AfterEach가 설정된 메서드는 하나의 테스트 메서드들이 실행되고 끝날 때마다 실행된다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        // optional에서 값을 꺼낼 때 get()을 사용. 좋은 방법은 아니지만 테스트 코드니까 get으로 함.
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        //Assertions.assertThat(member).isEqualTo(result);
        // Assertions를 static으로 import 해서 assertThat()을 바로 사용
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        //Assertions.assertThat(member1).isEqualTo(result);
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> list = repository.findAll();

        //assertThat(list.size()).isEqualTo(2);
        assertThat(list.size()).isEqualTo(2);
    }

}
