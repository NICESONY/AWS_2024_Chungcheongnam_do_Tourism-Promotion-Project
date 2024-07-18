package com.mysite.sbb.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}
	@GetMapping("/catecreate")
	public String catecreate() {
		return "admin/catecreate";
	}
	@PostMapping("/catecreate")
	public String catecreate(@ModelAttribute Cate cate) {
		
		adminService.catecreate(cate);
		return "admin/catecreate";
	}
}
