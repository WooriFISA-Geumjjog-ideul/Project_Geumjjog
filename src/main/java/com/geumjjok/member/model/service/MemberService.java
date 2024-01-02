package com.geumjjok.member.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.exception.MessageException;
import com.geumjjok.member.model.MemberDTO;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	// @FIXME: remove later - 유저 생성 테스트용
	public Member create(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO.toEntity());
	}

	public boolean signup(MemberDTO member) throws MessageException {
		Member memberEntity = member.toEntity();

		System.out.println("memberEntity : " + memberEntity);
		try {
			Member m = memberRepository.findMemberByName(member.getName());
			if (m == null) {
				memberEntity = memberRepository.save(memberEntity);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("이미 존재하는 이름입니다, 다시 입력하세요");
		}

		return false;
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

	public boolean emailCheck() {
		return false;
	}

	public String findPassword() {
		return "";
	}

	public String logout() {
		return "";
	}

}
