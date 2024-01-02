package com.geumjjok.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.member.model.MemberDTO;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;
import com.geumjjok.member.model.service.MemberService;

import jakarta.servlet.http.HttpSession;


@RequestMapping("/member")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	private MemberRepository memberRepository;
//	
//	public MemberController(MemberRepository member) {
//		this.memberRepository = member;
//	}
//	
	
	//@FIXME: remove later - 유저 생성 테스트용
	@PostMapping("/create")
	public Member create(@RequestBody MemberDTO memberDTO) {
		System.out.println("create");
		return memberService.create(memberDTO);
	}
	
	@PostMapping("/signup")
	protected String signup(MemberDTO member) throws Exception{
		try {
			boolean result = memberService.signup(member);
			if(result) {
				return "회원가입되었습니다!";
			}
			else {
				return "회원가입에 실패되었습니다";
			}
		}catch(Exception e) {
			return " ";
		}
		
	}
	

	@GetMapping("/login")
	public String login() {
		System.out.println("login");
		return null;
	}

	@GetMapping("/nickname-check")
	public boolean nicknameCheck(@RequestParam String nickname) {
		System.out.println("nicknameCheck");
		return false;
	}

	@GetMapping("/email-check")
	public boolean emailCheck(@RequestParam String email) {
		System.out.println("emailCheck");
		return false;
	}

	@GetMapping("/find-password")
	public String passwordFind(@RequestParam String password) {
		System.out.println("passwordFind");
		return null;
	}

	@GetMapping("/logout")
	public String logout() {
		System.out.println("logout");
		return null;
	}
}
