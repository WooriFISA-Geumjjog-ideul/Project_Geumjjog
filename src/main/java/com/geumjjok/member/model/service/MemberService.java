package com.geumjjok.member.model.service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.geumjjok.member.model.MemberDTO;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private MemberDTO convertToDto(Member member) {
		return MemberDTO.builder()
	            .memberId(member.getMemberId())
	            .name(member.getName())
	            .nickName(member.getNickName())
	            .password(member.getPassword())
	            .email(member.getEmail())
	            .createdAt(member.getCreatedAt().format(formatter))
	            .updatedAt(member.getUpdatedAt().format(formatter)) // Format LocalDateTime to String
	            .isDeleted(member.isDeleted())
	            .build();
	}
	
	//@FIXME: remove later - 유저 생성 테스트용
	public Member create(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO.toEntity());
	}
	
	public MemberDTO signup(@RequestBody MemberDTO memberDTO) {
		Optional<Member> optionalMember = memberRepository.findById(1);
		Member member = optionalMember.orElse(null);
		return convertToDto(memberRepository.save(memberDTO.toEntity()));
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
