package com.mysite.sbb.awsimage;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {
	
	
	@Autowired
	private NoticeRepostitoty noticeRepostitoty;
	
	
	@Autowired
	private S3service s3service;
	
	// 사진도 가져오는 법
	public void create(Notice notice, MultipartFile file1) throws IOException {
		
		
		// UUID 를 추가해서 사진 이름과 같이 DB로 뽑아 준다.
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename();
		
		s3service.uploadFile(file1, fileName1);
		
		notice.setImage1(fileName1);
		
		noticeRepostitoty.save(notice);
	}

}
