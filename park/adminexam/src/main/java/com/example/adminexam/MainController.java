package com.example.adminexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/readlist")
	public String readlist() {
		return "readlist";
	}
}