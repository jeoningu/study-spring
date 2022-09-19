package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
// 1-1
// JdbcMemberRepository, JdbcTemplateMemberRepository에 사용되는 bean
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

// 1-2
// JpaMemberRepository에 사용되는 bean
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
// service에 넣어줄 MemberRepository 설정
//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

// 2
//  spring data jpaRepository가 MemberRepository, JpaRepository를 상속 받은 SpringDataJpaMemberRepository를 보고 MemberRepository 빈을 생성한다.
// MemberRepository 빈을 주입 받게 설정한다.
    private final MemberRepository memberRepository;



    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//3
// TimeTraceAop.java에서 @Component로 빈을 생성함.
// 실무에서는 시간 측정같은 특수한 기능을 하는 aop Bean 설정은 aop로 쓰는 구나 인지하기 위해서
// @Configuration설정 클래스에서 @Bean으로 설정함.
//   @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
