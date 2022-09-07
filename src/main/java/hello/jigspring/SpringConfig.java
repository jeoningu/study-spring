package hello.jigspring;

import hello.jigspring.repository.MemberRepository;
import hello.jigspring.repository.MemoryMemberRepository;
import hello.jigspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
