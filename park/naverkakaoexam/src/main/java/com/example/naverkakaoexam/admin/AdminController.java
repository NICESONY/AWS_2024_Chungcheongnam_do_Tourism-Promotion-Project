package com.example.naverkakaoexam.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.naverkakaoexam.CustomerService;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private CustomerService customerSerivce;
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("customers", customerSerivce.readlist());
		return "main";
	}

}
