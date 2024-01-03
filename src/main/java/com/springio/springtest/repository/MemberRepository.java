package com.springio.springtest.repository;

import com.springio.springtest.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원 등록
    Member save(Member member);
    // 회원 조회
    // ID로 조회
    Optional<Member> findById(Long id);
    // Name으로 조회
    Optional<Member> findByName(String name);
    // 전체 조회
    List<Member> findAll();
}
