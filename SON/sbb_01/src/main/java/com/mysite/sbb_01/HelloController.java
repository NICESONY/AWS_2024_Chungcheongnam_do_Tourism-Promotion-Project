package com.mysite.sbb_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	@ResponseBody
	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

}
