package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository repository;
    MemberService service;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

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

        // when
        //Long saveId1 = service.join(member1);
        //try {
        //    service.join(member2);
        //    fail();
        //} catch (IllegalStateException e) {
        //    Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        //}

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}