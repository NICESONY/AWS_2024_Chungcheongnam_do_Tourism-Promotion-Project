package com.mysite.sbb.awsimage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NoticeController {
	
	
	@Autowired
	private NoticeService noticeService;
	

		
	@GetMapping("/")
	public String index() {
		return "index";
		
		}
	
	@GetMapping("/create")
	public String create() {
		return "create";
		
		}
	
	
	@GetMapping("/create")
	public String create(@ModelAttribute Notice notice,
						 @RequestParam("image1") MultipartFile file1
			) throws IOException {
		
		noticeService.create(notice, file1);
		return "redirect:/";
		
		}
	

	
	
	

}
