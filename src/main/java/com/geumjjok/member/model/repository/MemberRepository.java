package com.geumjjok.member.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geumjjok.member.model.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member findMemberByName(String name);
}
