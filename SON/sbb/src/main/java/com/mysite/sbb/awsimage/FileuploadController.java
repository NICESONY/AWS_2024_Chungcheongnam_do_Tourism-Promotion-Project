package com.mysite.sbb.awsimage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileuploadController {

	@Autowired
	private S3service s3Service;


	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		s3Service.uploadFile(file);
		return "redirect:/index";
	}


	
	@GetMapping("/download")
	public String download() {
		return "download";
	}
	

}