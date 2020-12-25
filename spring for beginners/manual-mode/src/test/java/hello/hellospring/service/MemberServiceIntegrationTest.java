package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService service;
    @Autowired MemberRepository repository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = service.join(member);

        //then
        Member result = service.findOne(saveId).get();
        Assertions.assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    public void dropDuplicateJoins() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //when
        service.join(member1);
        org.junit.jupiter.api
                .Assertions.assertThrows(IllegalStateException.class, () -> service.join(member2));


    }
}