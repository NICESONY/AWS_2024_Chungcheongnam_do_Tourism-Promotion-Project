package com.example.securityexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		
		return "signup";
	}
	@GetMapping("/signup")
	public String signup() {
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Member member) {
		
		memberService.create(member);
		return "signup";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "signin";
	}
}
