package com.example.extraclass.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

@Autowired
private MemberService memberService;

@GetMapping("/signup")
public String signup() {
return "signup";
}
@PostMapping("/signup")
public String signup(Member author) {
memberService.create(author);
return "signup";
}
@GetMapping("/signin")
public String signin() {
return "signin";
}

}
