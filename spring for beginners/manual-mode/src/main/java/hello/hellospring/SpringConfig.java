package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // pure jpa
    /**
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

     @Bean
     public MemberRepository memberRepository() {
     //return new MemoryMemberRepository();
     //return new JdbcMemberRepository(dataSource);
     //return new JdbcTemplateMemberRepository(dataSource);
     return new JpaMemberRepository(em);
     }
     **/

    /**
     * private final DataSource dataSource;
     * public SpringConfig(DataSource datasource) {}
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     **/

    @Bean
    public MemberService memberService () {
        return new MemberService(memberRepository);
    }

}
