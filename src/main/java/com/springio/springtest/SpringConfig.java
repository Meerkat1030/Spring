package com.springio.springtest;

import com.springio.springtest.repository.JdbcMemberRepository;
import com.springio.springtest.repository.MemberRepository;
import com.springio.springtest.repository.MemoryMemberRepository;
import com.springio.springtest.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
