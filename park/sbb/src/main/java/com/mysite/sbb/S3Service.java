package com.mysite.sbb;

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
public class S3Service {

	@Value("austinbucket1111")
	private String bucketName;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public void uploadFile(MultipartFile multipartFile, String fileName) throws IOException {
		
		// 현재 서버에 임시 저장
		File file = new File(multipartFile.getOriginalFilename());
		
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(multipartFile.getBytes());
		}
		
		
		// AWS 전송 - UUID 적용 버전, uuid로 적용된 파일이름을 가져와서 사용한다. 
		//String fileName = System.currentTimeMillis() + "_" + 
		//				  multipartFile.getOriginalFilename();
		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file));
		
		// 임시 저장된 사진 삭제
		file.delete();
	}	
}
