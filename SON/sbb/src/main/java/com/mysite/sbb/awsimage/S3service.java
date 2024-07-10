package com.mysite.sbb.awsimage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3service {
	
	
	
	@Value("samsam11")
	private String bucketName;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public void uploadFile(MultipartFile multipartFile, String fileName) throws IOException {
		
		
		//현재 서버에 임시 저장
		File file = new File(multipartFile.getOriginalFilename());
		
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(multipartFile.getBytes());
		}
		
		// AWS 전송 기존 밀리 세컨으로 처리했던 파일 명을 좀 더 전믄먹인 UUID 버전 교체함, 
		
		
		// AWS 전송
		/*
		 * String fileName = System.currentTimeMillis() + "_" +
		 * multipartFile.getOriginalFilename();
		 */
		
		
		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file));
		
		// 임시 저장된 사진 삭제 
		file.delete(); //임시 저장 파일 삭제
	}	
}