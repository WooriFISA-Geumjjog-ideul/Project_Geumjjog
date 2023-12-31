package com.geumjjok.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.member.model.service.MemberService;

@RequestMapping("/member")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/signup")
	public String signup() {
		System.out.println("signup");
		return null;
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

	@GetMapping("/find-password")
	public String passwordFind(@RequestParam String email) {
		System.out.println("passwordFind");
		return null;
	}

	@GetMapping("/email-check")
	public boolean emailCheck(@RequestParam String email) {
		System.out.println("emailCheck");
		return false;
	}

	@GetMapping("/logout")
	public String logout() {
		System.out.println("logout");
		return null;
	}
}
