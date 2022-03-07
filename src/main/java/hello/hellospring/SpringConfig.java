package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    //스프링 데이터 JPA가 SpringDataJpaMemberRepository를 스프링 빈으로 자동 등록해줌
    private final MemberRepository memberRepository;
//    private DataSource dataSource;
//    private EntityManager em;
    //원래 EntityManager 는 @PersistenceContext 사용해서 주입해줘야하지만 스프링에서 오토와이어드 해도 주입해줌

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean //직접 빈 등록
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
