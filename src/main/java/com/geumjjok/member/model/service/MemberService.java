package com.geumjjok.member.model.service;

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
	
	public String login() {
		return "";
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
