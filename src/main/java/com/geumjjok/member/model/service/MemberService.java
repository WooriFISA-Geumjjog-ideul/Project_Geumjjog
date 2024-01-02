package com.geumjjok.member.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.member.model.MemberDTO;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	//@FIXME: remove later - 유저 생성 테스트용
	public Member create(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO.toEntity());
	}
	
	public String signup() {
		return "";
	}
	
	public Optional<Member> login(MemberDTO memberDTO) {
		System.out.println(memberDTO.getName());
		Optional<Member> member = memberRepository.findByName(memberDTO.getName());
		System.out.println("memberService login");
		System.out.println(member);
		return member;
	}
	
	public boolean nicknameCheck() {
		return false;
	}
	
	public String findPassword() {
		return "";
	}
	
	public boolean emailCheck() {
		return false;
	}
	
	public String logout() {
		return "";
	}

	
	
}
