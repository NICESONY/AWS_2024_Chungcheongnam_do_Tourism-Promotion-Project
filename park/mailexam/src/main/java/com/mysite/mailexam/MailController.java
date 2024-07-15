package com.mysite.mailexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	@Autowired
	private MailService mailService;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	@PostMapping("/create")
	public String create(@RequestParam ("title") String title,
						 @RequestParam ("content") String content,
						 @RequestParam ("addr") String addr) {
		mailService.create(title, content, addr);
		return "index";
	}
}
