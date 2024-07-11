package com.example.bucketexample;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private S3Service s3Service;
	public void create(Notice notice, MultipartFile file1) throws IOException {
		
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename();
		
		s3Service.uploadFile(file1, fileName1);
		
		notice.setImage1(fileName1);
		noticeRepository.save(notice);
	}
	
	public List<Notice> readlist(){
		return noticeRepository.findAll();
	}
}