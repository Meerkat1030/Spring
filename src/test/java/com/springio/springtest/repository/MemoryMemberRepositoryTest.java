package com.springio.springtest.repository;

import com.springio.springtest.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MemoryMemberRepositoryTest{
    // 화면에서 그 기능을 실행시키면서 직접 테스트 할 수도 있고
    // main 메소드를 만들어서 실행 할 수도 있는데
    // 위 방법대로 하면 반복테스트가 힘듦
    // 테스트를 한번에 다 실행 하기가 힘듦

    // 이러한 문제를 해결하기 위해서 JUnit 프레임워크를 통해서 테스트를 진행
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 메소드 테스트를 끝낼 때마다 데이터를 지우는 코드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    void 회원가입(){
        // given
        Member member = new Member();
        member.setName("lee");
        // when
        repository.save(member);
        // then
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        // given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        // when
        List<Member> result = repository.findAll();
        // then

        assertThat(result.size()).isEqualTo(2);
    }
}
