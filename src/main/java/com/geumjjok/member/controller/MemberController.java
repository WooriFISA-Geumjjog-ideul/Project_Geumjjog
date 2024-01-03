package com.geumjjok.member.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.member.model.MemberDTO;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.service.MemberService;

import jakarta.servlet.http.HttpServletResponse;
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
	   public ResponseEntity<?> signup(@RequestBody MemberDTO member) throws Exception{
	      try {
	           boolean result = memberService.signup(member);
	           if(result) {
	               return ResponseEntity.ok().body("{\"message\":\"회원가입에 성공하였습니다.\"}");
	           } else {
	               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"회원가입에 실패하였습니다.\"}");
	           }
	       } catch(Exception e) {
	           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\":\"서버 오류가 발생하였습니다.\"}");
	       }
	      
	   }
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDTO memberDTO, HttpSession session, HttpServletResponse response) {
	    System.out.println("memberController login");
	    Optional<Member> optMember = memberService.login(memberDTO);
	    Member member = optMember.get();
	    if(optMember.isPresent()) {
	        session.setAttribute("member_info", member);
	        return ResponseEntity.ok().body("{\"message\":\"Login Success\"}");
	    } else {
	        return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
	    }
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
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
