package com.geumjjok.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.member.model.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
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
