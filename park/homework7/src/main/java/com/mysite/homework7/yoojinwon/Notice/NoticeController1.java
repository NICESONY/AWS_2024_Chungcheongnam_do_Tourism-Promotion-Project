package com.mysite.homework7.yoojinwon.Notice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController1 {
	
	private final NoticeService1 ns;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;
	
	@GetMapping("/")
	public String showNotices(Model model) {
		model.addAttribute("noticeList", ns.findallnotice());
		return "yoojinwon/noticelist1";
	}
	
	@GetMapping("/notice/add")
	public String addnotice() {
		return "yoojinwon/addnotice1";
	}
	
	@PostMapping("/notice/create")
	public String createnotice(@ModelAttribute Notice1 notice,
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,
			@RequestParam("file3") MultipartFile file3) throws IOException {
		
		ns.createnotice(notice, file1, file2, file3);
		
		return "redirect:/";
	}
	
	@GetMapping("/notice/detail/{id}")
	public String shownotice(Model model, 
							@PathVariable("id") Integer id) {
		model.addAttribute("notice",ns.getnoticeByid(id));
		model.addAttribute("downpath","https://"+downpath);
		return "yoojinwon/noticedetail1";
	}
	
	@GetMapping("/notice/detail/delete/{id}")
	public String deleteNotice(@PathVariable("id") Integer id) {
		ns.deleteNotice(id);
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updateNotice(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("notice",ns.getnoticeByid(id));
		return "yoojinwon/noticefix1";
	}
	@PostMapping("/notice/update")
	public String update(@ModelAttribute Notice1 notice,
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,
			@RequestParam("file3") MultipartFile file3) throws IOException {
		ns.update(notice, file1, file2, file3);
		return "redirect:/";
	}
}