package com.example.bucketexample;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute Notice notice,
						 @RequestParam("file")MultipartFile file) throws IOException {
		noticeService.create(notice, file);
		
		return "redirect:/";
	}
	
	@GetMapping("/readlist")
	public String readlist(Model model) {
		model.addAttribute("notices", noticeService.readlist());
		model.addAttribute("downpath", "https://" + downpath);
		return "readlist";
	}
}
